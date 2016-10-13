import org.custommonkey.xmlunit.Diff
import org.custommonkey.xmlunit.XMLUnit
import groovy.xml.StreamingMarkupBuilder

def expectedResult = '''
<food>
    <name>Avocado Slices</name>
    <mfr>Sunnydale</mfr>
    <serving units='g'>29</serving>
    <calories total='110' fat='100'></calories>
    <total-fat>11</total-fat>
    <saturated-fat>3</saturated-fat>
    <cholesterol>5</cholesterol>
    <sodium>210</sodium>
    <carb>2</carb>
    <fiber>0</fiber>
    <protein>1</protein>
    <vitamins>
        <a>0</a>
        <c>0</c>
    </vitamins>
    <minerals>
        <ca>0</ca>
        <fe>0</fe>
        <zn>2</zn>
    </minerals>
</food>
'''
def food = new XmlSlurper().parse(
  new File('singleFood.xml')) //Path to singleFood.xml
assert food.name == 'Avocado Dip'
//Modify the third food element name
food.name.replaceNode{node -> name("Avocado Slices")}
//Unlike XmlParser, XmlSlurper delays processing until needed
assert food.name == 'Avocado Dip'
food.minerals.appendNode{node -> zn("2")}

def outputBuilder = new groovy.xml.StreamingMarkupBuilder()
String result = outputBuilder.bind{ mkp.yield food }

XMLUnit.setIgnoreWhitespace(true)
def xmlDiff = new Diff(result, expectedResult)
assert xmlDiff.similar()
