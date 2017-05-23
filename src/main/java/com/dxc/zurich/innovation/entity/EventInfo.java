package com.dxc.zurich.innovation.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "eventinfo")
@SequenceGenerator(name = "eventinfo_sequence", sequenceName = "eventinfo_id_seq")
public class EventInfo extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id = null;
	private String core1 = "";
	private String core2 = "";
	private String core3 = "";
	private String core4 = "";
	private String core5 = "";
	private String core1name = "";
	private String core1desig1 = "";
	private String core1desig2 = "";
	private String core2name = "";
	private String core2desig1 = "";
	private String core2desig2 = "";
	private String core3name = "";
	private String core3desig1 = "";
	private String core3desig2 = "";
	private String core4name = "";
	private String core4desig1 = "";
	private String core4desig2 = "";
	private String core5name = "";
	private String core5desig1 = "";
	private String core5desig2 = "";
	private String core6 = "";
	private String core7 = "";
	private String core8 = "";
	private String core6name = "";
	private String core6desig1 = "";
	private String core6desig2 = "";
	private String core7name = "";
	private String core7desig1 = "";
	private String core7desig2 = "";
	private String core8name = "";
	private String core8desig1 = "";
	private String core8desig2 = "";
	private String closingComments = "";
	private String fromTheDeskFile1 = null;
	private String fromTheDeskFile2 = null;
	private String fromTheDeskFile3 = null;
	private Event event = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "eventinfo_sequence")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCore1() {
		return core1;
	}

	public void setCore1(String core1) {
		this.core1 = core1;
	}

	public String getCore2() {
		return core2;
	}

	public void setCore2(String core2) {
		this.core2 = core2;
	}

	public String getCore3() {
		return core3;
	}

	public void setCore3(String core3) {
		this.core3 = core3;
	}

	public String getCore4() {
		return core4;
	}

	public void setCore4(String core4) {
		this.core4 = core4;
	}

	public String getCore5() {
		return core5;
	}

	public void setCore5(String core5) {
		this.core5 = core5;
	}

	public String getCore1name() {
		return core1name;
	}

	public void setCore1name(String core1name) {
		this.core1name = core1name;
	}

	public String getCore1desig1() {
		return core1desig1;
	}

	public void setCore1desig1(String core1desig1) {
		this.core1desig1 = core1desig1;
	}

	public String getCore1desig2() {
		return core1desig2;
	}

	public void setCore1desig2(String core1desig2) {
		this.core1desig2 = core1desig2;
	}

	public String getCore2name() {
		return core2name;
	}

	public void setCore2name(String core2name) {
		this.core2name = core2name;
	}

	public String getCore2desig1() {
		return core2desig1;
	}

	public void setCore2desig1(String core2desig1) {
		this.core2desig1 = core2desig1;
	}

	public String getCore2desig2() {
		return core2desig2;
	}

	public void setCore2desig2(String core2desig2) {
		this.core2desig2 = core2desig2;
	}

	public String getCore3name() {
		return core3name;
	}

	public void setCore3name(String core3name) {
		this.core3name = core3name;
	}

	public String getCore3desig1() {
		return core3desig1;
	}

	public void setCore3desig1(String core3desig1) {
		this.core3desig1 = core3desig1;
	}

	public String getCore3desig2() {
		return core3desig2;
	}

	public void setCore3desig2(String core3desig2) {
		this.core3desig2 = core3desig2;
	}

	public String getCore4name() {
		return core4name;
	}

	public void setCore4name(String core4name) {
		this.core4name = core4name;
	}

	public String getCore4desig1() {
		return core4desig1;
	}

	public void setCore4desig1(String core4desig1) {
		this.core4desig1 = core4desig1;
	}

	public String getCore4desig2() {
		return core4desig2;
	}

	public void setCore4desig2(String core4desig2) {
		this.core4desig2 = core4desig2;
	}

	public String getCore5name() {
		return core5name;
	}

	public void setCore5name(String core5name) {
		this.core5name = core5name;
	}

	public String getCore5desig1() {
		return core5desig1;
	}

	public void setCore5desig1(String core5desig1) {
		this.core5desig1 = core5desig1;
	}

	public String getCore5desig2() {
		return core5desig2;
	}

	public void setCore5desig2(String core5desig2) {
		this.core5desig2 = core5desig2;
	}

	public String getClosingComments() {
		return closingComments;
	}

	public void setClosingComments(String closingComments) {
		this.closingComments = closingComments;
	}

	public String getFromTheDeskFile1() {
		return fromTheDeskFile1;
	}

	public void setFromTheDeskFile1(String fromTheDeskFile1) {
		this.fromTheDeskFile1 = fromTheDeskFile1;
	}

	public String getFromTheDeskFile2() {
		return fromTheDeskFile2;
	}

	public void setFromTheDeskFile2(String fromTheDeskFile2) {
		this.fromTheDeskFile2 = fromTheDeskFile2;
	}

	public String getFromTheDeskFile3() {
		return fromTheDeskFile3;
	}

	public void setFromTheDeskFile3(String fromTheDeskFile3) {
		this.fromTheDeskFile3 = fromTheDeskFile3;
	}

	public String getCore6() {
		return core6;
	}

	public void setCore6(String core6) {
		this.core6 = core6;
	}

	public String getCore7() {
		return core7;
	}

	public void setCore7(String core7) {
		this.core7 = core7;
	}

	public String getCore8() {
		return core8;
	}

	public void setCore8(String core8) {
		this.core8 = core8;
	}

	public String getCore6name() {
		return core6name;
	}

	public void setCore6name(String core6name) {
		this.core6name = core6name;
	}

	public String getCore6desig1() {
		return core6desig1;
	}

	public void setCore6desig1(String core6desig1) {
		this.core6desig1 = core6desig1;
	}

	public String getCore6desig2() {
		return core6desig2;
	}

	public void setCore6desig2(String core6desig2) {
		this.core6desig2 = core6desig2;
	}

	public String getCore7name() {
		return core7name;
	}

	public void setCore7name(String core7name) {
		this.core7name = core7name;
	}

	public String getCore7desig1() {
		return core7desig1;
	}

	public void setCore7desig1(String core7desig1) {
		this.core7desig1 = core7desig1;
	}

	public String getCore7desig2() {
		return core7desig2;
	}

	public void setCore7desig2(String core7desig2) {
		this.core7desig2 = core7desig2;
	}

	public String getCore8name() {
		return core8name;
	}

	public void setCore8name(String core8name) {
		this.core8name = core8name;
	}

	public String getCore8desig1() {
		return core8desig1;
	}

	public void setCore8desig1(String core8desig1) {
		this.core8desig1 = core8desig1;
	}

	public String getCore8desig2() {
		return core8desig2;
	}

	public void setCore8desig2(String core8desig2) {
		this.core8desig2 = core8desig2;
	}

	@JoinColumn(name = "event", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.EAGER)
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}