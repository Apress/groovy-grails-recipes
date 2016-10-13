def a = ['January','Feburary','March','April']
assert a.min{
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
}  == 'January'
