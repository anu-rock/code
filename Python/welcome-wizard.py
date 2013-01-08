#!/usr/bin/env python

#---------------------------------------------------------------
# Program         : Welcome Wizard
# File            : welcome-wizard
# Version         : 1.0
# Author          : Anurag Bhandari
# Contact	  : anurag.bhd@gmail.com
# Created On      : Mon May 12 20:00 IST 2008
# Licence	  : GPLv2
#---------------------------------------------------------------
# Copyright (C) 2008
#  Granular Project

# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2, or (at your option)
# any later version.

# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.

# You should have received a copy of the GNU General Public License
# along with this program; if not, write to the Free Software
# Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
# 02111-1307, USA.

import wx
import pygtk
pygtk.require('2.0')
import pynotify
import sys
import os


class Core:
	def __init__(self):
		self.variable = 0
	# Define the event handler for the Next button. Note that mentioning "event" as a parameter is important
	def next(self, event):
		self.variable = self.variable + 1
		self.core_func(self.variable)
	# Define the event handler for the Command button. Note that mentioning "event" as a parameter is important
	def execommand(self, event):
		if(self.variable == 1):
			os.system('amarok')
		elif(self.variable == 2):
			os.system('firefox')
		elif(self.variable == 3):
			os.system('drakconf')
	# Define the event handler for the Back button. Note that mentioning "event" as a parameter is important
	def back(self, event):
		self.variable = self.variable - 1
		self.core_func(self.variable)
	# Define the function to send notifications using the "python-notify" libraries
	def mynotification(self, title, say, xpos, ypos):
		if __name__ == '__main__':
			if not pynotify.init("XY"):
				sys.exit(1)
		n = pynotify.Notification(title, say)
		n.set_hint("x", xpos)
		n.set_hint("y", ypos)
		if not n.show():
        		print "Failed to send notification"
	# Define the core function which would display the contents on the wizard
	def core_func(self, param):
		if(param == 0):
			text.SetLabel(label="Your journey of exploration begins from here")
			backButton.Disable()
			commandButton.SetLabel(label='Command')
			commandButton.Disable()
		elif(param == 1):
			backButton.Enable()
			commandButton.Enable()
			title.SetLabel(label="Ajhdfldfghlkdfg")
			text.SetLabel(label="dskthldfghlkdfg")
			commandButton.SetLabel(label='Open Amarok')
		elif(param == 2):
			text.SetLabel(label="lkjhggl fgljhdgf l")
			self.mynotification(title="Hello", say="I am the Menu", xpos=30, ypos=25)
			commandButton.SetLabel(label='Open Firefox')
		elif(param == 3):
			text.SetLabel(label="dasfjsdgfksjdhf")
			nextButton.Enable()
			commandButton.Enable()
			self.mynotification(title="Hello", say="I am the Kicker", xpos=400, ypos=25)
			commandButton.SetLabel(label='Open Control Center')
		elif(param == 4):
			text.SetLabel(label="bye bye")
			nextButton.Disable()
			commandButton.SetLabel(label='Command')
			commandButton.Disable()
			
    
app = wx.App()
win = wx.Frame(None, title="Welcome to Granular", size=(640, 480))
win.CenterOnScreen()
bkg = wx.Panel(win)
# We define the object for our class "Core"
obj = Core()
backButton = wx.Button(bkg, label='Back')
backButton.Bind(wx.EVT_BUTTON, obj.back)
commandButton = wx.Button(bkg, label='Command')
commandButton.Bind(wx.EVT_BUTTON, obj.execommand)
# Unless the player has pressed the Next button for the first time, the Back and Command buttons will be disabled
backButton.Disable()
commandButton.Disable()
nextButton = wx.Button(bkg, label='Next')
nextButton.Bind(wx.EVT_BUTTON, obj.next)
nextButton.SetDefault()
i = wx.Image('./images/test-1.jpg', type=wx.BITMAP_TYPE_JPEG)
b = wx.BitmapFromImage(i)
image = wx.StaticBitmap(bkg, bitmap=b)
title = wx.StaticText(bkg, label="Welcome to Granular", style=wx.ALIGN_CENTER)
text = wx.StaticText(bkg, label="Your journey of exploration begins from here")
hline1 = wx.StaticLine(bkg, style=wx.LI_HORIZONTAL)
hline2 = wx.StaticLine(bkg, style=wx.LI_HORIZONTAL)
# We define some stylish fonts for the welcome message / game questions
font_title = wx.Font(pointSize=18, family=wx.DECORATIVE, style=wx.NORMAL, weight=wx.NORMAL)
font_text = wx.Font(pointSize=12, family=wx.DECORATIVE, style=wx.NORMAL, weight=wx.NORMAL)
title.SetFont(font_title)
text.SetFont(font_text)
hbox1 = wx.BoxSizer()
hbox2 = wx.BoxSizer()
hbox1.Add(image, proportion=0, flag=wx.LEFT | wx.RIGHT, border=10)
hbox1.Add(text, proportion=1, flag=wx.LEFT | wx.RIGHT, border=10)
hbox2.Add(backButton, proportion=1, flag=wx.LEFT, border=5)
hbox2.Add(commandButton, proportion=1, flag=wx.RIGHT, border=5)
hbox2.Add(nextButton, proportion=1, flag=wx.RIGHT, border=5)
vbox = wx.BoxSizer(wx.VERTICAL)
vbox.Add(title, proportion=0, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hline1, proportion=0, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hbox1, proportion=1, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hline2, proportion=0, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hbox2, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.BOTTOM | wx.RIGHT, border=5)
bkg.SetSizer(vbox)
win.Show()
app.MainLoop()