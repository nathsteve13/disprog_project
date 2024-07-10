
package project_client_taliscocaa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertDataReservasiAcara complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertDataReservasiAcara"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jumlah_tiket" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="acara_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertDataReservasiAcara", propOrder = {
    "jumlahTiket",
    "userId",
    "acaraId"
})
public class InsertDataReservasiAcara {

    @XmlElement(name = "jumlah_tiket")
    protected int jumlahTiket;
    @XmlElement(name = "user_id")
    protected int userId;
    @XmlElement(name = "acara_id")
    protected int acaraId;

    /**
     * Gets the value of the jumlahTiket property.
     * 
     */
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    /**
     * Sets the value of the jumlahTiket property.
     * 
     */
    public void setJumlahTiket(int value) {
        this.jumlahTiket = value;
    }

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
     * Gets the value of the acaraId property.
     * 
     */
    public int getAcaraId() {
        return acaraId;
    }

    /**
     * Sets the value of the acaraId property.
     * 
     */
    public void setAcaraId(int value) {
        this.acaraId = value;
    }

}
