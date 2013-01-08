import wx
import wx.wizard as wiz

def makePageTitle(wizPg, title):
    sizer = wx.BoxSizer(wx.VERTICAL)
    wizPg.SetSizer(sizer)
    title = wx.StaticText(wizPg, -1, title)
    title.SetFont(wx.Font(18, wx.SWISS, wx.NORMAL, wx.BOLD))
    sizer.AddWindow(title, 0, wx.ALIGN_CENTRE|wx.ALL, 5)
    sizer.AddWindow(wx.StaticLine(wizPg, -1), 0, wx.EXPAND|wx.ALL, 5)
    return sizer

class TitledPage(wiz.WizardPageSimple):
    def __init__(self, parent, title):
        wiz.WizardPageSimple.__init__(self, parent)
        self.sizer = makePageTitle(self, title)

app = wx.PySimpleApp()
wizard = wiz.Wizard(None, -1, "Simple Wizard")
page1 = TitledPage(wizard, "Welcome to Granular")
page2 = TitledPage(wizard, "Watch the magic of Granular!")
wiz.WizardPageSimple_Chain(page1, page2)
wizard.FitToPage(page1)
wizard.RunWizard(page1)
wizard.Destroy()
app.MainLoop() 
