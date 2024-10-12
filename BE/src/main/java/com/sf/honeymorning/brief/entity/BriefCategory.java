package com.sf.honeymorning.brief.entity;

import com.sf.honeymorning.domain.common.entity.BaseEntity;
import com.sf.honeymorning.tag.entity.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class BriefCategory extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brief_category_id")
	private Long id;

	@JoinColumn(name = "brief_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private com.sf.honeymorning.domain.brief.entity.Brief brief;

	@JoinColumn(name = "tag_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;

}
