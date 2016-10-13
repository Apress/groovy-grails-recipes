import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.*

xpath = '''
   /nutrition/food[vitamins/* > 0]/name
'''  //Selects food elements names that contain vitamins 

builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
doc = builder.parse(new File("food.xml"))//Path to XML document
expr = XPathFactory.newInstance().newXPath().compile(xpath)
nodes = expr.evaluate(doc, XPathConstants.NODESET)
def list = []
nodes.each{list+= it.textContent}
assert ["Beef Frankfurter, Quarter Pound"] == list
