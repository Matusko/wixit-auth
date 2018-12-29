package sk.matusko.wixit.common.dao

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull
import java.io.Serializable
import java.util.ArrayList

@Entity
@Table(name = "users")
class User : Serializable, Owner, UserDetails {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
        set(id) {
            field = this.id
        }

    @NotNull(message = "required")
    @Column(name = "firstname")
    private var firstName: String? = null

    @NotNull(message = "required")
    @Column(name = "lastname")
    private var lastName: String? = null

    @NotNull(message = "required")
    @Column(name = "username", nullable = false, unique = true)
    private var username: String? = null

    @NotNull(message = "required")
    @Column(name = "password", nullable = false)
    private var password: String? = null

    @Column(name = "enabled", nullable = false)
    private var enabled: Boolean = false

    constructor() {
    }

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    public fun setPassword(password: String) {
        this.password = password;
    }

    @JsonIgnore
    override fun owner(): User {
        return this
    }

    companion object {

        private const val serialVersionUID = 9160056901518133045L
    }

    @JsonIgnore
    override fun getAuthorities(): Collection<GrantedAuthority> {

        return ArrayList()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    @JsonIgnore
    override fun isAccountNonLocked(): Boolean {
        // we never lock accounts
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        // credentials never expire
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getUsername(): String? {
        return username
    }

    fun getFirstName(): String? {
        return this.firstName
    }

    fun getLastName(): String? {
        return this.lastName
    }
}