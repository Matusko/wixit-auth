package sk.matusko.wixit.auth.entities

import sk.matusko.wixit.auth.enums.Animal

class Pet {
    var id: Long = 0
    var name: String? = null
    var type: Animal? = null
    var age: Int = 0
}