import groovy.swing.SwingBuilder
import javax.swing.JOptionPane

swing = new SwingBuilder()
frame = swing.frame(title:'Date Spinner '){
  panel(){    
    label 'Date'
    spinner(model:spinnerDateModel())    
  }    
}

frame.pack()
frame.show()
