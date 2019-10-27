[
].forEach(el => {
    const currentPerson = db.MoscowIncomes.find({'idPerson': el['Id Person']})

    if (currentPerson != null) {
    db.MoscowIncomes.update({"_id": currentPerson._id},
        {$addToSet: {"relatives": [el]}},
        { multi: false, upsert: false}
    )
}

})