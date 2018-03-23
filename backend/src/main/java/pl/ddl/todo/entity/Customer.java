package pl.ddl.todo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.vaadin.example.backend.authentication.UserAuthenticationInfo;
import org.vaadin.example.backend.authentication.UserAuthorizationInfo;

@Entity
@Table(name = "cdiexamplecustomer")
public class Customer extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id", nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Column(name = "Username", nullable = false)
    private String username;

    @Column(name = "pw", nullable = false)
    private String password;

    @Column(name = "roles", nullable = false)
    private String roles = "";

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password in human readable format. The password will internally
     * be hashed.
     *
     * @param password
     */
    public void setHumanReadablePassword(String password) {
        this.password = new Sha512Hash(password, UserAuthenticationInfo.PW_SALT).toHex();
    }

    /*
     * This getter shouldn't exist but it's here because apache commons bean
     * utils will fail otherwise.
     */
    public String getHumanReadablePassword() {
        return null;
    }

    public void setPassword(String password) {
        if (password.length() != 128) {
            setHumanReadablePassword(password);
        } else {
            this.password = password;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthenticationInfo getAsAuthenticationInfo() {
        return new UserAuthenticationInfo(this);
    }

    public AuthorizationInfo getAsAuthorizationInfo() {
        return new UserAuthorizationInfo(this);
    }

    /**
     * @return Comma separated list of roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * Comma separated list of roles
     *
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * Adds given role to this customer
     *
     * @param role
     */
    public void addRole(String role) {
        StringBuilder allRoles = new StringBuilder();
        allRoles.append(roles);

        if (allRoles.length() == 0) {
            allRoles.append(role);
        } else {
            allRoles.append(",");
            allRoles.append(role);
        }

        roles = allRoles.toString();
    }
}
