package havis.device.rf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import havis.device.rf.capabilities.AntennaReceiveSensitivityRangeTable;
import havis.device.rf.capabilities.AntennaReceiveSensitivityRangeTableEntry;
import havis.device.rf.capabilities.DeviceCapabilities;
import havis.device.rf.capabilities.FixedFreqTable;
import havis.device.rf.capabilities.FreqHopTable;
import havis.device.rf.capabilities.FreqHopTableEntry;
import havis.device.rf.capabilities.ReceiveSensitivityTable;
import havis.device.rf.capabilities.ReceiveSensitivityTableEntry;
import havis.device.rf.capabilities.RegulatoryCapabilities;
import havis.device.rf.capabilities.TransmitPowerTable;
import havis.device.rf.capabilities.TransmitPowerTableEntry;
import havis.device.rf.configuration.AntennaConfiguration;
import havis.device.rf.configuration.AntennaProperties;
import havis.device.rf.configuration.ConnectType;
import havis.device.rf.configuration.InventorySettings;
import havis.device.rf.configuration.KeepAliveConfiguration;
import havis.device.rf.configuration.RssiFilter;
import havis.device.rf.configuration.SelectionMask;
import havis.device.rf.configuration.SingulationControl;

public class CloneTest {

	@Test
	public void testCloneDeviceCapabilities() {
		DeviceCapabilities devCaps1 = new DeviceCapabilities();
		AntennaReceiveSensitivityRangeTableEntry entry = new AntennaReceiveSensitivityRangeTableEntry();
		entry.setIndex((short)1);
		entry.setMin((short)5);
		entry.setMax((short)10);
		devCaps1.setAntennaReceiveSensitivityRangeTable(new AntennaReceiveSensitivityRangeTable());
		devCaps1.getAntennaReceiveSensitivityRangeTable().getEntryList().add(entry);
		
		ReceiveSensitivityTableEntry e = new ReceiveSensitivityTableEntry();
		e.setIndex((short)2);
		e.setReceiveSensitivity((short)15);		
		devCaps1.setReceiveSensitivityTable(new ReceiveSensitivityTable());
		devCaps1.getReceiveSensitivityTable().getEntryList().add(e);
		
		devCaps1.setFirmware("firmware");
		devCaps1.setManufacturer(4321);
		devCaps1.setMaxReceiveSensitivity((short)20);
		devCaps1.setModel(1234);
		devCaps1.setNumberOfAntennas((short)4);
		
		DeviceCapabilities devCaps2 = (DeviceCapabilities)devCaps1.clone();
		
		assertEquals(devCaps1.getAntennaReceiveSensitivityRangeTable().getEntryList().size(), 
				devCaps2.getAntennaReceiveSensitivityRangeTable().getEntryList().size());
		
		assertEquals(devCaps1.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getIndex(), 
				devCaps2.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getIndex());
		
		assertEquals(devCaps1.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getMax(), 
				devCaps2.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getMax());
		
		assertEquals(devCaps1.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getMin(), 
				devCaps2.getAntennaReceiveSensitivityRangeTable().getEntryList().get(0).getMin());
		
		assertEquals(devCaps1.getFirmware(), devCaps2.getFirmware());
		assertEquals(devCaps1.getManufacturer(), devCaps2.getManufacturer());
		assertEquals(devCaps1.getMaxReceiveSensitivity(), devCaps2.getMaxReceiveSensitivity());
		assertEquals(devCaps1.getModel(), devCaps2.getModel());
		assertEquals(devCaps1.getNumberOfAntennas(), devCaps2.getNumberOfAntennas());
		
		assertEquals(devCaps1.getReceiveSensitivityTable().getEntryList().size(), 
				devCaps2.getReceiveSensitivityTable().getEntryList().size());
		
		assertEquals(devCaps1.getReceiveSensitivityTable().getEntryList().get(0).getIndex(), 
				devCaps2.getReceiveSensitivityTable().getEntryList().get(0).getIndex());
		
		assertEquals(devCaps1.getReceiveSensitivityTable().getEntryList().get(0).getReceiveSensitivity(), 
				devCaps2.getReceiveSensitivityTable().getEntryList().get(0).getReceiveSensitivity());
	}
	
	@Test
	public void testCloneRegulatoryCapabilities() {
		RegulatoryCapabilities regCaps1 = new RegulatoryCapabilities();
		regCaps1.setCommunicationStandard((short)1);
		regCaps1.setCountryCode((short)2);
		
		regCaps1.setFixedFreqTable(new FixedFreqTable());
		regCaps1.getFixedFreqTable().getFreqList().add(3);
		
		regCaps1.setFreqHopTable(new FreqHopTable());		
		FreqHopTableEntry freqHopTableEntry = new FreqHopTableEntry();
		freqHopTableEntry.getFreqList().add(4);
		freqHopTableEntry.setIndex((short)5);		
		regCaps1.getFreqHopTable().getEntryList().add(freqHopTableEntry);
		
		regCaps1.setHopping(true);
		regCaps1.setTransmitPowerTable(new TransmitPowerTable());		
		TransmitPowerTableEntry transmitPowerTableEntry = new TransmitPowerTableEntry();
		transmitPowerTableEntry.setIndex((short)6);
		transmitPowerTableEntry.setTransmitPower((short)7);
		regCaps1.getTransmitPowerTable().getEntryList().add(transmitPowerTableEntry);
		
		RegulatoryCapabilities regCaps2 = (RegulatoryCapabilities) regCaps1.clone();
		
		assertEquals(regCaps1.getCommunicationStandard(), regCaps2.getCommunicationStandard());
		assertEquals(regCaps1.getCountryCode(), regCaps2.getCountryCode());

		assertEquals(regCaps1.getFixedFreqTable().getFreqList().size(), 
				regCaps2.getFixedFreqTable().getFreqList().size());
		
		assertEquals(regCaps1.getFixedFreqTable().getFreqList().get(0), 
				regCaps2.getFixedFreqTable().getFreqList().get(0));
		
		assertEquals(regCaps1.getFreqHopTable().getEntryList().size(), 
				regCaps2.getFreqHopTable().getEntryList().size());		
		
		assertEquals(regCaps1.getFreqHopTable().getEntryList().get(0).getIndex(), 
				regCaps2.getFreqHopTable().getEntryList().get(0).getIndex());
		
		assertEquals(regCaps1.getFreqHopTable().getEntryList().get(0).getFreqList().size(), 
				regCaps2.getFreqHopTable().getEntryList().get(0).getFreqList().size());
		
		assertEquals(regCaps1.getFreqHopTable().getEntryList().get(0).getFreqList().get(0), 
				regCaps2.getFreqHopTable().getEntryList().get(0).getFreqList().get(0));
	}
	
	@Test
	public void testCloneAntennaConfiguration() {
		AntennaConfiguration aCfg1 = new AntennaConfiguration();
		aCfg1.setChannelIndex((short) 1);
		aCfg1.setConnect(ConnectType.TRUE);
		aCfg1.setHopTableID((short)2);
		aCfg1.setId((short)3);
		aCfg1.setReceiveSensitivity((short)4);
		aCfg1.setTransmitPower((short)5);
		
		AntennaConfiguration aCfg2 = (AntennaConfiguration) aCfg1.clone();
		assertEquals(aCfg1.getChannelIndex(), aCfg2.getChannelIndex());
		assertEquals(aCfg1.getConnect(), aCfg2.getConnect());
		assertEquals(aCfg1.getHopTableID(), aCfg2.getHopTableID());
		assertEquals(aCfg1.getReceiveSensitivity(), aCfg2.getReceiveSensitivity());
		assertEquals(aCfg1.getTransmitPower(), aCfg2.getTransmitPower());		
	}
	
	@Test
	public void testCloneAntennaProperties() {
		AntennaProperties aPrp1 = new AntennaProperties();
		aPrp1.setConnected(true);
		aPrp1.setGain((short)1);
		aPrp1.setId((short)2);
		
		AntennaProperties aPrp2 = (AntennaProperties)aPrp1.clone();
		assertEquals(aPrp1.isConnected(), aPrp2.isConnected());
		assertEquals(aPrp1.getGain(), aPrp2.getGain());
		assertEquals(aPrp1.getId(), aPrp2.getId());
	}
	
	@Test
	public void testCloneKeepAliveConfiguration() {
		KeepAliveConfiguration kaCfg1 = new KeepAliveConfiguration();
		kaCfg1.setEnable(true);
		kaCfg1.setInterval(500);
		
		KeepAliveConfiguration kaCfg2 = (KeepAliveConfiguration) kaCfg1.clone();
		assertEquals(kaCfg1.isEnable(), kaCfg2.isEnable());
		assertEquals(kaCfg1.getInterval(), kaCfg2.getInterval());
	}
	
	@Test
	public void testCloneInventorySettings() {
		InventorySettings invCfg1 = new InventorySettings();
		invCfg1.setSingulationControl(new SingulationControl());
		invCfg1.getSingulationControl().setQValue((short)1);
		invCfg1.getSingulationControl().setRounds((short)2);
		invCfg1.getSingulationControl().setSession((short)3);
		invCfg1.getSingulationControl().setTransitTime((short)200);
		
		invCfg1.setRssiFilter(new RssiFilter());
		invCfg1.getRssiFilter().setMinRssi((short)-64);
		invCfg1.getRssiFilter().setMaxRssi((short)64);
				
		invCfg1.getSelectionMasks().add(new SelectionMask());
		invCfg1.getSelectionMasks().get(0).setBank((short)1);
		invCfg1.getSelectionMasks().get(0).setBitLength((short)96);
		invCfg1.getSelectionMasks().get(0).setBitOffset((short)32);
		invCfg1.getSelectionMasks().get(0).setMask(new byte[] { 
			(byte)0xa1, (byte)0xa2, (byte)0xa3, (byte)0xa4, 
			(byte)0xb1, (byte)0xb2, (byte)0xb3, (byte)0xb4 });
		
		InventorySettings invCfg2 = (InventorySettings) invCfg1.clone();
		
		assertEquals(invCfg1.getSingulationControl().getQValue(), invCfg2.getSingulationControl().getQValue());
		assertEquals(invCfg1.getSingulationControl().getRounds(), invCfg2.getSingulationControl().getRounds());
		assertEquals(invCfg1.getSingulationControl().getSession(), invCfg2.getSingulationControl().getSession());
		assertEquals(invCfg1.getSingulationControl().getTransitTime(), invCfg2.getSingulationControl().getTransitTime());
				
		assertEquals(invCfg1.getRssiFilter().getMinRssi(), invCfg2.getRssiFilter().getMinRssi());
		assertEquals(invCfg1.getRssiFilter().getMaxRssi(), invCfg2.getRssiFilter().getMaxRssi());
		
		assertEquals(invCfg1.getSelectionMasks().size(), invCfg2.getSelectionMasks().size());
		assertEquals(invCfg1.getSelectionMasks().get(0).getBank(), invCfg2.getSelectionMasks().get(0).getBank());
		assertEquals(invCfg1.getSelectionMasks().get(0).getBitLength(), invCfg2.getSelectionMasks().get(0).getBitLength());
		assertEquals(invCfg1.getSelectionMasks().get(0).getBitOffset(), invCfg2.getSelectionMasks().get(0).getBitOffset());
		assertArrayEquals(invCfg1.getSelectionMasks().get(0).getMask(), invCfg2.getSelectionMasks().get(0).getMask());
	}

}
