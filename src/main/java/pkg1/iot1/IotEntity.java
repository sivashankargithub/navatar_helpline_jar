package pkg1.iot1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="iot1")
public class IotEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String pulse;
	private String oxi_lavel;
	private String ecg;
	private String accelerometery;
	
	public IotEntity() {
		super();
	}
	
	public IotEntity(int id, String name, String pulse, String oxi_lavel, String ecg, String accelerometery) {
		super();
		this.id = id;
		this.name = name;
		this.pulse = pulse;
		this.oxi_lavel = oxi_lavel;
		this.ecg = ecg;
		this.accelerometery = accelerometery;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getOxi_lavel() {
		return oxi_lavel;
	}
	public void setOxi_lavel(String oxi_lavel) {
		this.oxi_lavel = oxi_lavel;
	}
	public String getEcg() {
		return ecg;
	}
	public void setEcg(String ecg) {
		this.ecg = ecg;
	}
	public String getAccelerometery() {
		return accelerometery;
	}
	public void setAccelerometery(String accelerometery) {
		this.accelerometery = accelerometery;
	}
}
