def nutrition = new XmlParser().parse(
new File('food.xml')) //Path to XML file
def dailyValues =  nutrition.'daily-values'
assert dailyValues.'total-fat'.text() == '65'
assert dailyValues.'total-fat'.'@units'[0] == 'g'

def firstFood = nutrition.food[0]
assert firstFood.name.text() == 'Avocado Dip'
assert firstFood.serving.'@units'[0] == 'g'
assert firstFood.serving.text() == '29'
def vitamins = firstFood.vitamins
assert vitamins.a.text() == '0'
def minerals = firstFood.minerals
assert minerals.ca.text() == '0'

def secondFood = nutrition.food[1]
assert secondFood.name.text() == 'Bagels, New York Style'
assert secondFood.serving.'@units'[0] == 'g'
assert secondFood.serving.text() == '104'
vitamins = secondFood.vitamins
assert vitamins.a.text() == '0'
minerals = secondFood.minerals
assert minerals.ca.text() == '8'

def thirdFood = nutrition.food[2]
thirdFood.name[0].value = ['Beef Frankfurter'] //Modify the third food element name
assert thirdFood.name.text() == 'Beef Frankfurter'
assert thirdFood.serving.'@units'[0] == 'g'
assert thirdFood.serving.text() == '115'
vitamins = thirdFood.vitamins
assert vitamins.a.text() == '0'
minerals = thirdFood.minerals
minerals.ca[0].value = '10' //Modify the third food calcium value
assert minerals.ca.text() == '10'
minerals[0].appendNode('zn', '3') //Add a new mineral (Zinc)
assert minerals.zn.text() == '3'

assert ['Bagels, New York Style', 'Beef Frankfurter'] == 
    nutrition.food.findAll {Integer.parseInt(it.minerals.ca.text()) > 0}
     .name*.text() //Food with calcium

assert ['Sunnydale', 'Thompson', 'Armitage'] ==
  nutrition.depthFirst().grep {it.mfr}.mfr*.text() //List of all mfrs
