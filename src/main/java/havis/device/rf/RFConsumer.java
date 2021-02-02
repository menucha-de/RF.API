package havis.device.rf;

import havis.device.rf.tag.TagData;
import havis.device.rf.tag.operation.RequestOperation;
import havis.device.rf.tag.operation.TagOperation;

import java.util.List;

/**
 * Describes a callback interface used by the RF controller to send signals to
 * the caller.
 * 
 */
public interface RFConsumer {

	/**
	 * Called by the {@link RFDevice} if the currently executed operation is
	 * a {@link RequestOperation} instance, to get additional operations to be
	 * executed for this request operation.
	 * 
	 * @param tag
	 *            the RFID tag the request operation is currently executed on
	 * @return a list of additional {@link TagOperation} instances. This list
	 *         can contain any operation except additional request operations.
	 */
	List<TagOperation> getOperations(TagData tag);

	/**
	 * Receiver for the keep-alive signal sent by the {@link RFDevice}.
	 */
	void keepAlive();

	/**
	 * Called by the {@link RFDevice} if another process tries to get
	 * exclusive hardware access. The {@link RFConsumer} may release its
	 * hardware access, if this signal is received. If the hardware access is
	 * not released within a certain timespan, the requesting process will
	 * receive an exception.
	 */
	void connectionAttempted();
}
