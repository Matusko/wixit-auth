package sk.matusko.wixit.auth.resolvers

import java.util.ArrayList
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import sk.matusko.wixit.auth.entities.Pet
import sk.matusko.wixit.auth.enums.Animal

@Component
class Query : GraphQLQueryResolver {

    fun pets(): List<Pet> {
        val pets = ArrayList<Pet>()

        val aPet = Pet()
        aPet.id = 1
        aPet.name = "Bill"
        aPet.age = 9
        aPet.type = Animal.MAMMOTH
        pets.add(aPet)

        return pets
    }
}