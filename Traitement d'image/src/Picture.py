#!/usr/bin/python
# -*- coding: utf-8 -*-

from PyQt4 import QtCore, QtGui
import Image, ImageQt


##
# Classe de manipulation d'image
#
class Picture():
    def __init__(self):
        self.image = 0
        self.data = []                  # Couleur de chaque pixel
        self.palette = None             # Palette de couleurs utilis�e pour les images index�es
    
    # Ouvre une image
    def open(self, filename):
        print "Ouverture de l'image ..."
        self.setImage(Image.open(filename))
        
        print "Mode :", self.image.mode
    
    # Donne une image
    def setImage(self, image):
        self.image = image
        self.data = list(self.image.getdata())
    
    # Modifie une couleur de la palette
    def setPaletteColor(self, pos, newColor):
        # V�rifie les absices
        if pos[0] < 0:
            pos[0] = 0
        elif pos[0] >= self.image.size[0]:
            pos[0] = self.image.size[0] - 1
        
        # Verifie les ordonn�es
        if pos[1] < 0:
            pos[1] = 0
        elif pos[1] >= self.image.size[1]:
            pos[1] = self.image.size[1] - 1
        
        # Niveau de gris
        if self.image.mode == "L":
            # V�rification des param�tres
            if type(newColor) != type(0):
                print "Erreur: Color doit �tre en niveau de gris !", newColor
                return
            
            if newColor < 0:
                newColor = 0
            elif newColor > 255:
                newColor = 255
            
            # R�cup�re l'ancienne couleur
            oldColor = self.image.getpixel(pos)
            
            # Remplace la couleur
            for index, value in enumerate(self.data):
                if value == oldColor:
                    self.data[index] = newColor
        
            # Recr�e l'image
            self.image.putdata(self.data)
        # Couleurs index�e
        elif self.image.mode == "P":
            # V�rification des param�tres
            if type(newColor) != type((0,0)):
                print "Erreur: Color doit �tre en RGB !", newColor
                return
            
            for index, value in enumerate(newColor):
                if value < 0:
                    newColor[index] = 0
                elif value > 255:
                    newColor[index] = 255
            
            # R�cup�re la palette
            if self.palette == None:
                self.getPalette()
            
            # R�cup�re la position de la couleur
            index = self.image.getpixel(pos) * 3
            
            self.palette[index] = newColor[0]
            self.palette[index + 1] = newColor[1]
            self.palette[index + 2] = newColor[2]
            
            #? Enregistre les modifications
            self.image.putpalette(self.palette)
    
    # Modifie la taille de l'image
    def setSize(self, w, h):
        if w <= 0 or h <= 0 or self.image == 0:
            return 0
        
        # R�cup�re les data de la nouvelle image
        data = []
        
        quantity = w    # Nombre de pixel pris par ligne
        reste = 0       # Pixel a cr�er par ligne
        
        if quantity >= self.getSize()[0]:
            reste = quantity - self.getSize()[0]
            quantity = self.getSize()[0]
        
        # Pour chaque ligne
        for y in range(h):
            first = (y * self.getSize()[0])
            
            data.extend(self.data[first:first + quantity])
            data.extend([data[-1]] * reste)
        
        # Cr�ation de la nouvelle image
        image = Image.new(self.image.mode, (w, h))
        image.putdata(data)
        image.putpalette(self.getPalette())
        self.setImage(image)
    
    # Donne une image Qt depuis une image PIL
    def getQtImage(self):
        # Bug dans PIL: conversion d'une image index�e/grayscale vers QImage -> image blanche
        # On convrtit donc l'image en RGB pour contourner le probl�me
        self.QtImage = ImageQt.ImageQt(self.image.convert("RGB"))
        return QtGui.QImage(self.QtImage)
    
    # Donne un pixmap affichable dans Qt
    def getPixmap(self):
        self.pixmap = QtGui.QPixmap.fromImage(self.getQtImage())
        return self.pixmap
    
    # Donne les dimensions de l'image
    def getSize(self):
        if self.image == 0:
            return (0, 0)
        
        return self.image.size
        
    # Donne le pixel voulu
    def getPixel(self, x, y):
        if self.image == 0:
            return (0, 0, 0)
        
        # Couleurs index�e
        if self.image.mode == "P":
            if self.palette == None:
                self.getPalette()
            
            index = self.image.getpixel((x, y)) * 3
            r = self.palette[index]
            g = self.palette[index + 1]
            b = self.palette[index + 2]
            
            return (r, g, b)
        
        return self.image.getpixel((x, y))
        
    # Donne le ROI d�finit par les deux points donn�
    def getROI(self, a, b):
        # Taille de la ROI
        w = abs(a[0] - b[0])
        h = abs(a[1] - b[1])
        print "Taille de la ROI :", (w, h)
        
        if w == 0 or h == 0:
            return 0
        
        # X coordon�e
        if a[0] <= b[0]:
            x1 = a[0]
            x2 = b[0]
        else:
            x1 = b[0]
            x2 = a[0]
        
        # Y coordon�e
        if a[1] <= b[1]:
            y1 = a[1]
            y2 = b[1]
        else:
            y1 = b[1]
            y2 = a[1]
            
        # R�cup�re les donn�es de l'image charg�e
        if self.data == []:
            self.data = list(self.image.getdata())
        
        # Extrait les donn�e de la ROI depuis les donn�es de l'image charg�e
        data = []
        for y in range(y1, y2):
            for x in range(x1, x2):
                data.append(self.data[(y * self.image.size[0]) + x])
        
        # Cr�e la ROI
        roi = Image.new(self.image.mode, (w, h))
        roi.putdata(data)
        
        return roi
    
    # G�n�re la palette si elle n'existe pas
    def getPalette(self):
        if self.image.mode != "P":
            print "Aucune palette disponnible pour ce mode"
            return None
        
        self.palette = self.image.getpalette()
        return self.palette
        