[].reduce((obj, item) => {
(obj[item['Id Person']] ? obj[item['Id Person']] : obj[item['Id Person']] = []).push(item);
return obj;
}, {})

const data = Object.keys(map).map(key => map[key].reduce((obj, item) => {
    if(item['Доход']) {
    obj.incomes.push(item);
}

return obj;
}, {
    incomes: []
}))

data.map((el, i) => {
    var mainPerson;
if (i === 0) {
    // update
}
})
