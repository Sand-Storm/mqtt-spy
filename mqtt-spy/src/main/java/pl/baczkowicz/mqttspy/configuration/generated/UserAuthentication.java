//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.31 at 10:50:55 PM BST 
//


package pl.baczkowicz.mqttspy.configuration.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import pl.baczkowicz.mqttspy.common.generated.UserCredentials;


/**
 * <p>Java class for UserAuthentication complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserAuthentication"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://baczkowicz.pl/mqtt-spy/common}UserCredentials"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AskForUsername" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="AskForPassword" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserAuthentication", propOrder = {
    "askForUsername",
    "askForPassword"
})
public class UserAuthentication
    extends UserCredentials
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "AskForUsername")
    protected boolean askForUsername;
    @XmlElement(name = "AskForPassword")
    protected boolean askForPassword;

    /**
     * Default no-arg constructor
     * 
     */
    public UserAuthentication() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public UserAuthentication(final boolean askForUsername, final boolean askForPassword) {
        this.askForUsername = askForUsername;
        this.askForPassword = askForPassword;
    }

    /**
     * Gets the value of the askForUsername property.
     * 
     */
    public boolean isAskForUsername() {
        return askForUsername;
    }

    /**
     * Sets the value of the askForUsername property.
     * 
     */
    public void setAskForUsername(boolean value) {
        this.askForUsername = value;
    }

    /**
     * Gets the value of the askForPassword property.
     * 
     */
    public boolean isAskForPassword() {
        return askForPassword;
    }

    /**
     * Sets the value of the askForPassword property.
     * 
     */
    public void setAskForPassword(boolean value) {
        this.askForPassword = value;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            boolean theAskForUsername;
            theAskForUsername = this.isAskForUsername();
            strategy.appendField(locator, this, "askForUsername", buffer, theAskForUsername);
        }
        {
            boolean theAskForPassword;
            theAskForPassword = this.isAskForPassword();
            strategy.appendField(locator, this, "askForPassword", buffer, theAskForPassword);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof UserAuthentication)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final UserAuthentication that = ((UserAuthentication) object);
        {
            boolean lhsAskForUsername;
            lhsAskForUsername = this.isAskForUsername();
            boolean rhsAskForUsername;
            rhsAskForUsername = that.isAskForUsername();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "askForUsername", lhsAskForUsername), LocatorUtils.property(thatLocator, "askForUsername", rhsAskForUsername), lhsAskForUsername, rhsAskForUsername)) {
                return false;
            }
        }
        {
            boolean lhsAskForPassword;
            lhsAskForPassword = this.isAskForPassword();
            boolean rhsAskForPassword;
            rhsAskForPassword = that.isAskForPassword();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "askForPassword", lhsAskForPassword), LocatorUtils.property(thatLocator, "askForPassword", rhsAskForPassword), lhsAskForPassword, rhsAskForPassword)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            boolean theAskForUsername;
            theAskForUsername = this.isAskForUsername();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "askForUsername", theAskForUsername), currentHashCode, theAskForUsername);
        }
        {
            boolean theAskForPassword;
            theAskForPassword = this.isAskForPassword();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "askForPassword", theAskForPassword), currentHashCode, theAskForPassword);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof UserAuthentication) {
            final UserAuthentication copy = ((UserAuthentication) draftCopy);
            {
                boolean sourceAskForUsername;
                sourceAskForUsername = this.isAskForUsername();
                boolean copyAskForUsername = strategy.copy(LocatorUtils.property(locator, "askForUsername", sourceAskForUsername), sourceAskForUsername);
                copy.setAskForUsername(copyAskForUsername);
            }
            {
                boolean sourceAskForPassword;
                sourceAskForPassword = this.isAskForPassword();
                boolean copyAskForPassword = strategy.copy(LocatorUtils.property(locator, "askForPassword", sourceAskForPassword), sourceAskForPassword);
                copy.setAskForPassword(copyAskForPassword);
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new UserAuthentication();
    }

}