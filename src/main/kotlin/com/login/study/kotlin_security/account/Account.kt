package com.login.study.kotlin_security.account

import org.hibernate.annotations.CreationTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
data class Account(

        @Id @GeneratedValue
        var id: Long? = null,
        var email: String,
        var password: String,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableSet<AccountRole>,

        @CreationTimestamp
        var createDt: LocalDateTime = LocalDateTime.now()
){
        constructor(): this(0,"","", mutableSetOf(AccountRole.USER))
        fun getAuthorities():User {
                return User(
                        this.email, this.password,
                        this.roles.stream().map { SimpleGrantedAuthority("ROLE_$it") }.collect(Collectors.toSet())
                )
        }
}