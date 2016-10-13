import groovy.swing.SwingBuilder

swing = new SwingBuilder()
frame = swing.frame(title:'Action Demo'){
  panel(){
    message = textField(columns:10)
    button('Print text', actionPerformed: {event -> println message.text})
  }    
}
frame.pack()
frame.show()
