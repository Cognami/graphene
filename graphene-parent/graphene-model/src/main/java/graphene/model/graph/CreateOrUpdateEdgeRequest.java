package graphene.model.graph;

import java.util.Map;

import mil.darpa.vande.generic.V_GenericEdge;
import mil.darpa.vande.generic.V_GenericNode;

public class CreateOrUpdateEdgeRequest {
	V_GenericNode nodeA;
	String relationType;
	String relationValue;
	V_GenericNode nodeB;
	double nodeCertainty = 0.0;
	double minimumScoreRequired = 0.0;
	Map<String, V_GenericEdge> edgeList;

	public CreateOrUpdateEdgeRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nodeA
	 */
	public final V_GenericNode getNodeA() {
		return nodeA;
	}

	/**
	 * @param nodeA
	 *            the nodeA to set
	 */
	public final void setNodeA(V_GenericNode nodeA) {
		this.nodeA = nodeA;
	}

	/**
	 * @return the relationType
	 */
	public final String getRelationType() {
		return relationType;
	}

	/**
	 * @param relationType
	 *            the relationType to set
	 */
	public final void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	/**
	 * @return the relationValue
	 */
	public final String getRelationValue() {
		return relationValue;
	}

	/**
	 * @param relationValue
	 *            the relationValue to set
	 */
	public final void setRelationValue(String relationValue) {
		this.relationValue = relationValue;
	}

	/**
	 * @return the nodeB
	 */
	public final V_GenericNode getNodeB() {
		return nodeB;
	}

	/**
	 * @param nodeB
	 *            the nodeB to set
	 */
	public final void setNodeB(V_GenericNode nodeB) {
		this.nodeB = nodeB;
	}

	/**
	 * @return the nodeCertainty
	 */
	public final double getNodeCertainty() {
		return nodeCertainty;
	}

	/**
	 * @param nodeCertainty
	 *            the nodeCertainty to set
	 */
	public final void setNodeCertainty(double nodeCertainty) {
		this.nodeCertainty = nodeCertainty;
	}

	/**
	 * @return the minimumScoreRequired
	 */
	public final double getMinimumScoreRequired() {
		return minimumScoreRequired;
	}

	/**
	 * @param minimumScoreRequired
	 *            the minimumScoreRequired to set
	 */
	public final void setMinimumScoreRequired(double minimumScoreRequired) {
		this.minimumScoreRequired = minimumScoreRequired;
	}

	/**
	 * @return the edgeList
	 */
	public final Map<String, V_GenericEdge> getEdgeList() {
		return edgeList;
	}

	/**
	 * @param edgeList
	 *            the edgeList to set
	 */
	public final void setEdgeList(Map<String, V_GenericEdge> edgeList) {
		this.edgeList = edgeList;
	}

}
