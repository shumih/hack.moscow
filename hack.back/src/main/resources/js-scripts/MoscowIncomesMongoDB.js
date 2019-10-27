[].filter(el => (el['Доход'] && Object.keys(el).length === 8))
.forEach(person => {
    db.MoscowIncomes.insertOne({
        "idPerson": person['Id Person'],
        "fullName": person['ФИО'],
        "position": person['Должность'],
        "declarationType": person['Тип декларации'],
        "yearOfDeclaration": person['Год'],
        "authority": person['Орган Власти'],
        "region": person['Регион'],
        "totalIncome": person['Доход']
    })
})