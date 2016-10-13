import groovy.swing.SwingBuilder
import javax.swing.JOptionPane

swing = new SwingBuilder()
button = swing.button(text: 'Show Text', actionPerformed: {
JOptionPane.showMessageDialog(frame, message.text)
})
frame = swing.frame(title:'Action Demo'){
    panel(){
    message = textField(columns:10)
    widget(button)
    }    
}
frame.pack()
frame.show()
