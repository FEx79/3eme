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
        self.data = []
    
    # Ouvre une image
    def open(self, filename):
        self.setImage(Image.open(filename))
    
    # Donne une image
    def setImage(self, image):
        self.image = image
        self.data = list(self.image.getdata())
    
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
        """ Version 1
            for x in range(w):
                # Si le point voulu n'existait pas sur l'image de base
                if x >= self.getSize()[0] or y >= self.getSize()[1]:
                    data.append(data[-1])
                    continue
                
                i = (y * self.getSize()[0]) + x
                data.append(self.data[i])
        """
        
        # Cr�ation de la nouvelle image
        resized = Image.new(self.image.mode, (w, h))
        resized.putdata(data)
        
        return resized
        
    # Donne une image Qt depuis une image PIL
    def getQtImage(self):
        self.QtImage = ImageQt.ImageQt(self.image)
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
        self.roi = Image.new(self.image.mode, (w, h))
        self.roi.putdata(data)
        
        return self.roi