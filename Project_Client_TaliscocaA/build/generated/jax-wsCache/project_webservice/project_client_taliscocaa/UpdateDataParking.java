
package project_client_taliscocaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateDataParking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDataParking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parking_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="total_slotparkir" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="status_parking" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDataParking", propOrder = {
    "parkingId",
    "totalSlotparkir",
    "statusParking"
})
public class UpdateDataParking {

    @XmlElement(name = "parking_id")
    protected int parkingId;
    @XmlElement(name = "total_slotparkir")
    protected int totalSlotparkir;
    @XmlElement(name = "status_parking")
    protected String statusParking;

    /**
     * Gets the value of the parkingId property.
     * 
     */
    public int getParkingId() {
        return parkingId;
    }

    /**
     * Sets the value of the parkingId property.
     * 
     */
    public void setParkingId(int value) {
        this.parkingId = value;
    }

    /**
     * Gets the value of the totalSlotparkir property.
     * 
     */
    public int getTotalSlotparkir() {
        return totalSlotparkir;
    }

    /**
     * Sets the value of the totalSlotparkir property.
     * 
     */
    public void setTotalSlotparkir(int value) {
        this.totalSlotparkir = value;
    }

    /**
     * Gets the value of the statusParking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusParking() {
        return statusParking;
    }

    /**
     * Sets the value of the statusParking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusParking(String value) {
        this.statusParking = value;
    }

}
