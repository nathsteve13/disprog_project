
package project_client_taliscocaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertDataReservasiParking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertDataReservasiParking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="parking_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tanggal_parkir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertDataReservasiParking", propOrder = {
    "userId",
    "parkingId",
    "tanggalParkir"
})
public class InsertDataReservasiParking {

    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "parking_id")
    protected int parkingId;
    @XmlElement(name = "tanggal_parkir")
    protected String tanggalParkir;

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

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
     * Gets the value of the tanggalParkir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTanggalParkir() {
        return tanggalParkir;
    }

    /**
     * Sets the value of the tanggalParkir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTanggalParkir(String value) {
        this.tanggalParkir = value;
    }

}
