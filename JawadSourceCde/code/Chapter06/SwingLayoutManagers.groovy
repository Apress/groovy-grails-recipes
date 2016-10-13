import groovy.swing.SwingBuilder
import javax.swing.SwingConstants
import java.awt.*

swing = new SwingBuilder()
frame = swing.frame(title:'GridLayout Demo'){
  panel(layout:gridBagLayout() ){
    label(text:"Label",horizontalAlignment:SwingConstants.CENTER,
    constraints:gbc(gridx:0,gridy:0,gridwidth:GridBagConstraints.REMAINDER,
    fill:GridBagConstraints.HORIZONTAL, insets:[0,10,10,10]))
    button(text:"Button", constraints:gbc(gridx:0,gridy:1))
  }
}

frame.pack()
frame.show()
