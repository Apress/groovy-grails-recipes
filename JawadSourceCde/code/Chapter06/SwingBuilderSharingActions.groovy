import groovy.swing.SwingBuilder
import javax.swing.JOptionPane

swing = new SwingBuilder()
showText = swing.action(name:'Show Text', closure:  {
  JOptionPane.showMessageDialog(frame, message.text)
})
frame = swing.frame(title:'Action Demo'){
  menuBar{
    menu('Tools'){
      menuItem('Show text', action: showText)
    }
  }
  panel(){
    message = textField(columns:10)
    widget(button)
  }    
}
button = swing.button(text: 'Show Text', action:showText)
frame.pack()
frame.show()
