const neDB = require('../configurations/database')
const api = {}

api.findAll = (request, response) => {
    
    neDB.find({}).sort({name: 1}).exec((exception, customers) => {
        if (exception) {
            const setence = 'Opa, deu ruim na tentiva de listar todos os customers!'
            console.log(setence, exception)

            response.status(exception.status | 400)
            response.json({'mensagem': setence})
        }

        response.status(226)
        response.json(customers)
    })
    
    /*
    neDB.findOne({ name: 'Dio Branco'}).exec(function (exception, customers) {
        if (exception) {
            const setence = 'Opa, deu ruim na tentiva de listar todos os customers!'
            console.log(setence, exception)

            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }

        response.status(226)
        response.json(customers)
    }) 
    */
}

api.save = (request, response) => {
    const canonical = request.body

    neDB.insert(canonical, (exception, customer) => {
        if (exception) {
            console.log('Opa, deu ruim na tentiva de inserir um customer', exception)

            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }

        response.status(201)
        response.json(customer)
    })
}

module.exports = api