a =  [9,2,5,6,3]
assert a.sort() == [2,3,5,6,9]

months = ["March","April","January","Feburary"]
assert months.sort{
    switch(it){
    case 'January' : return 1
    break
    case 'Feburary' : return 2
    break
    case 'March' : return 3
    break
    case 'April' : return 4
    break
    default : return 1
    }
} == ["January", "Feburary", "March", "April"]
