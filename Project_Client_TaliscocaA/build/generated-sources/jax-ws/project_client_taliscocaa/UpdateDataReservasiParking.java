
package project_client_taliscocaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateDataReservasiParking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateDataReservasiParking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reservasi_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateDataReservasiParking", propOrder = {
    "reservasiId"
})
public class UpdateDataReservasiParking {

    @XmlElement(name = "reservasi_id")
    protected int reservasiId;

    /**
     * Gets the value of the reservasiId property.
     * 
     */
    public int getReservasiId() {
        return reservasiId;
    }

    /**
     * Sets the value of the reservasiId property.
     * 
     */
    public void setReservasiId(int value) {
        this.reservasiId = value;
    }

}
