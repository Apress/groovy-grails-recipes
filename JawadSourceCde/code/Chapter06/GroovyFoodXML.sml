import groovy.xml.MarkupBuilder

class Food{
  String name,mfr
  Map serving, calories, vitamins, minerals
  int totalFat, saturatedFat, cholesterol, sodium, carb, fiber,protein
}

def foodBuilder(builder, food){
  builder.'food'
  {name(food.name)
    mfr(food.mfr)
    serving(units:food.serving.units,food.serving.value)
    calories(total:food.calories.total, fat:food.calories.fat)
    'total-fat'(food.totalFat)
    'saturated-fat'(food.saturatedFat)
    cholesterol(food.cholesterol)
    sodium(food.sodium)
    carb(food.carb)
    fiber(food.fiber)
    protein(food.protein)
    vitamins{
    food.vitamins.each{"$it.key"(it.value)}
  }
  minerals{
    food.minerals.each{"$it.key"(it.value)}
  }
  }
}

Food food1 = new Food(name:'Avocado Dip', mfr: 'Sunnydale',
    serving: ['units':'g','value':29], 
    calories: ['total' : 110, 'fat' : 100], 
    totalFat: 11, saturatedFat: 3, cholesterol:5, sodium:210, carb:2,
    fiber:0, protein:1,
    vitamins: ['a' : 0, 'c' :0],
    minerals: ['ca' : 0 , 'fe' :0])

Food food2 = new Food(name:'Bagels, New York Style', mfr: 'Thompson',
    serving: ['units':'g','value':104], 
    calories: ['total' : 300, 'fat' : 35], 
    totalFat: 4, saturatedFat: 1, cholesterol:0, sodium:510, carb:54,
    fiber:3, protein:11,
    vitamins: ['a' : 0, 'c' :01],
    minerals: ['ca' : 8 , 'fe' :20])

Food food3 = new Food(name:'Beef Frankfurter, Quarter Pound', mfr: 'Armitage',
    serving: ['units':'g','value':115], 
    calories: ['total' : 370, 'fat' : 290], 
    totalFat: 32, saturatedFat: 15, cholesterol:65, sodium:1100, carb:8,
    fiber:0, protein:13,
    vitamins: ['a' : 0, 'c' :2],
    minerals: ['ca' : 1 , 'fe' :6])

def writer = new FileWriter('C:\\temp\\food.xml')
def builder = new groovy.xml.MarkupBuilder(writer)
builder.nutrition{
  'daily-values'{
    'total-fat'(units:'g',65)
    'saturated-fat'(units:'g',20)
    'cholesterol'(units:'mg',300)
    'sodium'(units:'mg',2400)
    'carb'(units:'g',300)
    'fiber'(units:'g',25)
    'protein'(units:'g',50)
  }
  foodBuilder(builder, food1)
  foodBuilder(builder, food2)
  foodBuilder(builder, food3)

}
