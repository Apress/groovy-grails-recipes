import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.frame(title:'Built with SwingBuilder'){
  menuBar{
    menu('Help'){
      menuItem 'About'
    }
  }
  panel {
    label 'Select a color'
    colorChooser()
  }
}

frame.pack()
frame.show()
