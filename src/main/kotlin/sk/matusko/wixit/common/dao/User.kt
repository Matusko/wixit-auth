package sk.matusko.wixit.common.dao

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull
import java.io.Serializable

@Entity
@Table(name = "users")
class User : Serializable, Owner {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
        set(id) {
            field = this.id
        }

    @Column(name = "firstname")
    private var firstName: String? = null

    @NotNull(message = "1")
    @Column(name = "lastname")
    private var lastName: String? = null

    constructor() {
    }

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    @JsonIgnore
    override val owner: User = this

    companion object {

        private const val serialVersionUID = 9160056901518133045L
    }
}