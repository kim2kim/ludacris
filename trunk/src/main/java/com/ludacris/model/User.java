package com.ludacris.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableProperty;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

/**
 * This class represents the basic "user" object in AppFuse that allows for
 * authentication and user management. It implements Acegi Security's
 * UserDetails interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Updated by
 *         Dan Kibler (dan@getrolling.com) Extended to implement Acegi
 *         UserDetails interface by David Carter david@carter.net
 */
@Entity
@Table(name = "user")
@Searchable
public class User extends BaseObject implements Serializable, UserDetails {
	private static final long serialVersionUID = 3832626162173359411L;

	@Column(nullable = false, length = 50, unique = true)
	@SearchableProperty
	private String username;

	@Column(nullable = false)
	private String password; // required

	@Transient
	private String confirmPassword;

	@Column(name = "password_hint")
	private String passwordHint;

	@Column(name = "first_name", nullable = false, length = 50)
	@SearchableProperty
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName; // required

	@Column(nullable = false, unique = true)
	@SearchableProperty
	private String email; // required; unique

	@Column(name = "phone_number")
	@SearchableProperty
	private String phoneNumber;

	@Embedded
	@SearchableComponent
	private Address address = new Address();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	private boolean enabled;

	@Column(name = "account_expired", nullable = false)
	private boolean accountExpired;

	@Column(name = "account_locked", nullable = false)
	private boolean accountLocked;

	@Column(name = "credentials_expired", nullable = false)
	private boolean credentialsExpired;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private Date dob;
	// @UserType

	@Column(name = "user_type")
	private String userType;

	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public User() {
		super();
	}

	/**
	 * Create a new instance and set the username.
	 * 
	 * @param username
	 *            login name for user.
	 */
	public User(final String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public String getFirstName() {
		return firstName;
	}

	@SearchableProperty
	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Returns the full name.
	 * 
	 * @return firstName + ' ' + lastName
	 */
	@Transient
	public String getFullName() {
		return firstName + ' ' + lastName;
	}

	public Address getAddress() {
		return address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Convert user roles to LabelValue objects for convenience.
	 * 
	 * @return a list of LabelValue objects with role information
	 */
	@Transient
	public List<LabelValue> getRoleList() {
		List<LabelValue> userRoles = new ArrayList<LabelValue>();

		if (this.roles != null) {
			for (Role role : roles) {
				// convert the user's roles to LabelValue Objects
				userRoles.add(new LabelValue(role.getName(), role.getName()));
			}
		}

		return userRoles;
	}

	/**
	 * Adds a role for the user
	 * 
	 * @param role
	 *            the fully instantiated role
	 */
	public void addRole(Role role) {
		getRoles().add(role);
	}

	/**
	 * @return GrantedAuthority[] an array of roles.
	 * @see org.springframework.security.userdetails.UserDetails#getAuthorities()
	 */
	@Transient
	public GrantedAuthority[] getAuthorities() {
		return roles.toArray(new GrantedAuthority[0]);
	}

	/*
	 * @Version public Integer getVersion() { return version; }
	 */

	@Column(name = "account_enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * @see org.springframework.security.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Transient
	public boolean isAccountNonExpired() {
		return !isAccountExpired();
	}

	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * @see org.springframework.security.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Transient
	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * @see org.springframework.security.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Transient
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	/*
	 * public void setId(Long id) { this.id = id; }
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setRoles(HashSet<Role> roles) {
		this.roles = roles;
	}

	/*
	 * public void setVersion(Integer version) { this.version = version; }
	 */

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}

		final User user = (User) o;

		return !(username != null ? !username.equals(user.getUsername()) : user
				.getUsername() != null);

	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		return (username != null ? username.hashCode() : 0);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("username", this.username)
				.append("enabled", this.enabled).append("accountExpired",
						this.accountExpired).append("credentialsExpired",
						this.credentialsExpired).append("accountLocked",
						this.accountLocked);

		GrantedAuthority[] auths = this.getAuthorities();
		if (auths != null) {
			sb.append("Granted Authorities: ");

			for (int i = 0; i < auths.length; i++) {
				if (i > 0) {
					sb.append(", ");
				}
				sb.append(auths[i].toString());
			}
		} else {
			sb.append("No Granted Authorities");
		}
		return sb.toString();
	}
}
