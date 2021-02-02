package havis.device.rf;

import havis.device.rf.capabilities.Capabilities;
import havis.device.rf.capabilities.CapabilityType;
import havis.device.rf.configuration.Configuration;
import havis.device.rf.configuration.ConfigurationType;
import havis.device.rf.exception.CommunicationException;
import havis.device.rf.exception.ConnectionException;
import havis.device.rf.exception.ImplementationException;
import havis.device.rf.exception.ParameterException;
import havis.device.rf.tag.Filter;
import havis.device.rf.tag.TagData;
import havis.device.rf.tag.operation.TagOperation;
import havis.device.rf.tag.result.OperationResult;

import java.util.List;

/**
 * Defines a commen RF controller.
 * 
 */
public interface RFDevice {

	/**
	 * <p>
	 * Tries to get exclusive access to the RF hardware and registers a
	 * {@link RFConsumer} instance <code>consumer</code> as access owner and
	 * call back receiver.
	 * </p>
	 * 
	 * <p>
	 * If a process tries to get hardware access that is already exlusively
	 * owned by another process, the owning process may release the hardware
	 * access to give it to the requesting process. If the owning process does
	 * not realase the hardware access a {@link ConnectionException} is thrown.
	 * </p>
	 * 
	 * <p>
	 * This given <code>timeout</code> specifies the amount of time in
	 * milliseconds, the owning process has to release the hardware access until
	 * a {@link ConnectionException} is thrown to the requesting process.
	 * </p>
	 * 
	 * @param consumer
	 *            an implementation of the {@link RFConsumer} interface
	 * @param timeout
	 *            Specifies an timespan in milliseconds which the requesting
	 *            process will wait for exclusive hardware access.
	 * 
	 * @throws ConnectionException
	 *             if another process holds the exclusive hardware access and
	 *             did not release before the given timeout was reached
	 * @throws ImplementationException
	 *             if an internal error occurrs
	 */
	void openConnection(RFConsumer consumer, int timeout) throws ConnectionException, ImplementationException;

	/**
	 * Closes the exclusive hardware access.
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 */
	void closeConnection() throws ConnectionException;

	/**
	 * Returns a list of capabilities, the RF controller (i.e. the RFID
	 * hardware) provides. The parameter <code>type</code> specifies the
	 * capability type requested. To request all capabilities the capability
	 * type enum constant {@link CapabilityType#ALL} can be passed.
	 * 
	 * @param type
	 *            an {@link CapabilityType} enum constant
	 * 
	 * @return List of {@link Capabilities} the RF controller provides depending
	 *         on the given <code>type</code>
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 * 
	 */
	List<Capabilities> getCapabilities(CapabilityType type) throws ImplementationException, ConnectionException;

	/**
	 * Return the actual configuration of the RF controller in a list depending
	 * on the type, antenna, GPI and GPO port. The <code>type</code> is a
	 * constant of the enum {@link ConfigurationType}. To request the
	 * configuration of all types specify the enum constant
	 * {@link CapabilityType#ALL}.
	 * 
	 * @param type
	 *            {@link ConfigurationType} enum constant
	 * @param antennaID
	 *            the ID of the antenna for which the configuration is requested
	 * @param gpiPort
	 *            the number of the GPI port for which the configuration is
	 *            requested
	 * @param gpoPort
	 *            the number of the GPO port for which the configuration is
	 *            requested
	 * @return The actual configuration of the RF-Controller in a list depending
	 *         on the type, antennaID, gpiPort and gpoPort.
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 * @throws ImplementationException
	 *             if an internal error occurrs
	 */
	List<Configuration> getConfiguration(ConfigurationType type, short antennaID, short gpiPort, short gpoPort)
			throws ConnectionException, ImplementationException;

	/**
	 * Updates the current configuration with the {@link Configuration} objects
	 * in the specified list.
	 * 
	 * @param configuration
	 *            a list of {@link Configuration} objects to update the current
	 *            configuration with
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 * @throws ImplementationException
	 *             if an internal error occurrs
	 * @throws ParameterException
	 *             if the configuration parameters specified are faulty
	 */
	void setConfiguration(List<Configuration> configuration)
			throws ConnectionException, ImplementationException, ParameterException;

	/**
	 * Performs a factory reset on the RF configuration.
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 * @throws ImplementationException
	 *             if an internal error occurrs
	 * @throws ParameterException
	 *             if the default parameters are faulty and cannot be restored
	 */
	void resetConfiguration() throws ImplementationException, ConnectionException, ParameterException;

	/**
	 * <p>
	 * Performts an inventory on the specified antennas applying the specified
	 * filters. On each RFID tag that is reported during inventory phase, each
	 * operation in the <code>operations</code> list is executed.
	 * </p>
	 * 
	 * <p>
	 * If the list of antennas only includes the number 0, the inventory and
	 * operations will be done on <b>all</b> antennas. If the operations list is
	 * empty only an inventory will be done. If the list of filters is empty,
	 * all tags on are reported without applying any filters.
	 * </p>
	 * 
	 * <p>
	 * Result is a list {@link TagData} objects, each having a list of
	 * {@link OperationResult} objects, one for each tag operation specified in
	 * <code>operations</code>.
	 * </p>
	 * 
	 * @param antennas
	 *            a list of antenna IDs or a list only containing 0.
	 * 
	 * @param filter
	 *            a list of {@link Filter} instances to by applied during
	 *            inventory phase.
	 * 
	 * @param operations
	 *            a list of {@link TagOperation} objects to be executed on each
	 *            tag found in the order as the operations appear in the list.
	 * 
	 * @return a list of {@link TagData} objects representing the RFID tags
	 *         found. Each tag data object has a list of {@link OperationResult}
	 *         instances, one per operation as specified by the
	 *         <code>operations</code> list.
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 * @throws ImplementationException
	 *             if an internal error occurrs
	 * @throws ParameterException
	 *             if there are faulty parameters in tag operations as specified
	 *             in the <code>operations</code> list
	 * 
	 */
	List<TagData> execute(List<Short> antennas, List<Filter> filter, List<TagOperation> operations)
			throws ParameterException, CommunicationException, ImplementationException, ConnectionException;

	/**
	 * Returns a list of region IDs that are supported by the underlying RFID
	 * hardware and the implementation. IDs in the result list can be used to
	 * switch the RFID module to another region. The special region ID
	 * 'Unspecified' describes an undefined region state. If the region
	 * 'Unspecified' is set on the module, all its antennas are disabled.
	 * 
	 * @return a list of region ID strings
	 * 
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 */
	List<String> getSupportedRegions() throws ConnectionException;

	/**
	 * Sets the regulatory capabilities of the configuration to those of the
	 * region with the given ID. By changing the region the indices of the
	 * antenna configuration are reset to 0. To get a list of supported region
	 * IDs use {@link #getSupportedRegions()}.
	 * 
	 * @param id
	 *            a region ID of a supported region
	 * @throws ParameterException
	 *             if the given region ID is invalid
	 * @throws ImplementationException
	 *             if an internal error occurs
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 */
	void setRegion(String id) throws ParameterException, ImplementationException, ConnectionException;

	/**
	 * Returns the region code of the currently active region.
	 * 
	 * @return the region code of the currently active region.
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 */
	String getRegion() throws ConnectionException;

	/**
	 * Installs a new firmware version to the RFID module.
	 * 
	 * @throws ImplementationException
	 * @throws ConnectionException
	 *             if the caller does not have exclusive hardware access. In
	 *             that case, call {@link #openConnection(RFConsumer, int)}
	 *             first.
	 */
	void installFirmware() throws ImplementationException, ConnectionException;
}
