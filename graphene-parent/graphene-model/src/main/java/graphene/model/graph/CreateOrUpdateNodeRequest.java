package graphene.model.graph;

import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;

public class CreateOrUpdateNodeRequest {
	double minimumScoreRequired = 0.0;
	String originalId;
	String idType;
	String nodeType;
	V_GenericNode attachTo;
	String relationType;
	String relationValue;
	double nodeCertainty = 0.0;
	V_GenericGraph subgraph;
	String reportId;

	/**
	 * @return the reportId
	 */
	public final String getReportId() {
		return reportId;
	}

	/**
	 * @param reportId
	 *            the reportId to set
	 */
	public final void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public CreateOrUpdateNodeRequest() {
		// TODO Auto-generated constructor stub
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
	 * @return the originalId
	 */
	public final String getOriginalId() {
		return originalId;
	}

	/**
	 * @param originalId
	 *            the originalId to set
	 */
	public final void setOriginalId(String originalId) {
		this.originalId = originalId;
	}

	/**
	 * @return the idType
	 */
	public final String getIdType() {
		return idType;
	}

	/**
	 * @param idType
	 *            the idType to set
	 */
	public final void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the nodeType
	 */
	public final String getNodeType() {
		return nodeType;
	}

	/**
	 * @param nodeType
	 *            the nodeType to set
	 */
	public final void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	/**
	 * @return the attachTo
	 */
	public final V_GenericNode getAttachTo() {
		return attachTo;
	}

	/**
	 * @param attachTo
	 *            the attachTo to set
	 */
	public final void setAttachTo(V_GenericNode attachTo) {
		this.attachTo = attachTo;
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
	 * @return the subgraph
	 */
	public final V_GenericGraph getSubgraph() {
		return subgraph;
	}

	/**
	 * @param subgraph
	 *            the subgraph to set
	 */
	public final void setSubgraph(V_GenericGraph subgraph) {
		this.subgraph = subgraph;
	}

}
