#!/usr/bin/python
# -*- coding: utf-8 -*-

import sys, os
import time
from PyQt4 import QtCore, QtGui
import Image
import ImageQt
from layout.windowsLayout import Ui_MainWindow


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
        
    # Donne une image Qt depuis une image PIL
    def getQtImage(self):
        self.QtImage = ImageQt.ImageQt(self.image)
        return QtGui.QImage(self.QtImage)
    
    # Donne un pixmap affichable dans Qt
    def getPixmap(self):
        self.pixmap = QtGui.QPixmap.fromImage(self.getQtImage())
        return self.pixmap
        
    # Donne le ROI d�finit par les deux points donn�
    def getROI(self, a, b):
        # Taille de la ROI
        w = abs(a[0] - b[0])
        h = abs(a[1] - b[1])
        print "Taille de la ROI :", (w, h)
        
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