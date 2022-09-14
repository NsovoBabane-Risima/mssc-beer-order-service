package guru.framework.msscbeerorderservice.web.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.Null;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseItem {

	@Null
	@JsonProperty("id")
	private UUID id;
	@Version
	private Integer version;
	@Null
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ssZ")
	@JsonProperty("createdDate")
	private OffsetDateTime createdDate;

	@Null
	@JsonProperty("lastModifiedDate")
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-mm-dd'T'HH:mm:ssZ")
	private OffsetDateTime lastModifiedDate;

}
