# experiment with wxPython's
# wx.media.MediaCtrl(parent, id, pos, size, style, backend)
# the backend (szBackend) is usually figured by the control
# wxMEDIABACKEND_DIRECTSHOW   Windows
# wxMEDIABACKEND_QUICKTIME    Mac OS X
# wxMEDIABACKEND_GSTREAMER    Linux (?)
# plays files with extension .mid .mp3 .wav .au .avi .mpg
# tested with Python24 and wxPython26 on Windows XP   vegaseat  10mar2006

import wx
import wx.media
import os

class Panel1(wx.Panel):
    def __init__(self, parent, id):
        #self.log = log
        wx.Panel.__init__(self, parent, -1, style=wx.TAB_TRAVERSAL|wx.CLIP_CHILDREN)

        # Create some controls
        try:
            self.mc = wx.media.MediaCtrl(self, style=wx.SIMPLE_BORDER)
        except NotImplementedError:
            self.Destroy()
            raise

        loadButton = wx.Button(self, -1, "Load File")
        self.Bind(wx.EVT_BUTTON, self.onLoadFile, loadButton)
        
        playButton = wx.Button(self, -1, "Play")
        self.Bind(wx.EVT_BUTTON, self.onPlay, playButton)
        
        pauseButton = wx.Button(self, -1, "Pause")
        self.Bind(wx.EVT_BUTTON, self.onPause, pauseButton)
        
        stopButton = wx.Button(self, -1, "Stop")
        self.Bind(wx.EVT_BUTTON, self.onStop, stopButton)

        slider = wx.Slider(self, -1, 0, 0, 0, size=wx.Size(300, -1))
        self.slider = slider
        self.Bind(wx.EVT_SLIDER, self.onSeek, slider)
        
        self.st_file = wx.StaticText(self, -1, ".mid .mp3 .wav .au .avi .mpg", size=(200,-1))
        self.st_size = wx.StaticText(self, -1, size=(100,-1))
        self.st_len  = wx.StaticText(self, -1, size=(100,-1))
        self.st_pos  = wx.StaticText(self, -1, size=(100,-1))
        
        # setup the button/label layout using a sizer
        sizer = wx.GridBagSizer(5,5)
        sizer.Add(loadButton, (1,1))
        sizer.Add(playButton, (2,1))
        sizer.Add(pauseButton, (3,1))
        sizer.Add(stopButton, (4,1))
        sizer.Add(self.st_file, (1, 2))
        sizer.Add(self.st_size, (2, 2))
        sizer.Add(self.st_len,  (3, 2))
        sizer.Add(self.st_pos,  (4, 2))
        sizer.Add(self.mc, (5,1), span=(5,1))  # for .avi .mpg video files
        self.SetSizer(sizer)

        self.timer = wx.Timer(self)
        self.Bind(wx.EVT_TIMER, self.onTimer)
        self.timer.Start(100)
        
    def onLoadFile(self, evt):
        dlg = wx.FileDialog(self, message="Choose a media file",
                            defaultDir=os.getcwd(), defaultFile="",
                            style=wx.OPEN | wx.CHANGE_DIR )
        if dlg.ShowModal() == wx.ID_OK:
            path = dlg.GetPath()
            self.doLoadFile(path)
        dlg.Destroy()
        
    def doLoadFile(self, path):
        if not self.mc.Load(path):
            wx.MessageBox("Unable to load %s: Unsupported format?" % path, "ERROR", wx.ICON_ERROR | wx.OK)
        else:
            folder, filename = os.path.split(path)
            self.st_file.SetLabel('%s' % filename)
            self.mc.SetBestFittingSize()
            self.GetSizer().Layout()
            self.slider.SetRange(0, self.mc.Length())
            self.mc.Play()
        
    def onPlay(self, evt):
        self.mc.Play()
    
    def onPause(self, evt):
        self.mc.Pause()
    
    def onStop(self, evt):
        self.mc.Stop()
    
    def onSeek(self, evt):
        offset = self.slider.GetValue()
        self.mc.Seek(offset)

    def onTimer(self, evt):
        offset = self.mc.Tell()
        self.slider.SetValue(offset)
        self.st_size.SetLabel('size: %s ms' % self.mc.Length())
        self.st_len.SetLabel('( %d seconds )' % (self.mc.Length()/1000))
        self.st_pos.SetLabel('position: %d ms' % offset)


app = wx.PySimpleApp()
# create a window/frame, no parent, -1 is default ID
frame = wx.Frame(None, -1, "play audio and video files", size = (320, 350))
# call the derived class
Panel1(frame, -1)
frame.Show(1)
app.MainLoop() 
