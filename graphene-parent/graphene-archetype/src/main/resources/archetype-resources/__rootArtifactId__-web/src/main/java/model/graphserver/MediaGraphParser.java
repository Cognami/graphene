#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model.graphserver;

import graphene.dao.G_Parser;

import graphene.model.graph.CreateOrUpdateNodeRequest;
import ${package}.model.media.CommentData;
import ${package}.model.media.LikeData;
import ${package}.model.media.Media;
import graphene.model.idl.G_CanonicalPropertyType;
import graphene.model.idl.G_CanonicalRelationshipType;
import graphene.model.idl.G_Entity;
import graphene.model.idl.G_EntityQuery;
import graphene.model.idl.G_EntityTag;
import graphene.model.idl.G_Property;
import graphene.model.idl.G_PropertyTag;
import graphene.model.idl.G_PropertyType;
import graphene.model.idl.G_SearchResult;
import graphene.model.idlhelper.EntityHelper;
import graphene.model.idlhelper.PropertyHelper;
import graphene.util.validator.ValidationUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mil.darpa.vande.generic.V_GenericGraph;
import mil.darpa.vande.generic.V_GenericNode;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * This is a parser for a particular document type in this application.
 */
public class MediaGraphParser extends ${projectName}Parser<Media> {

	public MediaGraphParser() {
		supported = new ArrayList<String>(1);
		supported.add("media");
		parenting = false;
	}

	@Override
	public G_Entity buildEntityFromDocument(final JsonNode sr, final G_EntityQuery q) {

		final Map<String, G_Property> map = new HashMap<String, G_Property>();
		resetLists();
		final Media p = getClassFromJSON(sr, Media.class);
		if (!ValidationUtils.isValid(p)) {
			logger.error("Error building DTO from Json for document " + sr.toString());
			return null;
		}

		map.put(G_Parser.REPORT_TYPE, new PropertyHelper(G_Parser.REPORT_TYPE, G_Parser.REPORT_TYPE, "media",
				Collections.singletonList(G_PropertyTag.ENTITY_TYPE)));

		map.put(MEDIA_LABEL, new PropertyHelper(MEDIA_LABEL, MEDIA_LABEL, getReportLabel(p),
				Collections.singletonList(G_PropertyTag.LABEL)));
		map.put(MEDIA_ID,
				new PropertyHelper(MEDIA_ID, MEDIA_ID, p.getId(), Collections.singletonList(G_PropertyTag.ID)));
		map.put(MEDIA_LINK, new PropertyHelper(MEDIA_LINK, MEDIA_LINK, p.getLink(),
				Collections.singletonList(G_PropertyTag.LINKED_DATA)));
		map.put(MEDIA_OWNER, new PropertyHelper(MEDIA_OWNER, MEDIA_OWNER, p.getUsername(),
				Collections.singletonList(G_PropertyTag.ID)));
		map.put(MEDIA_CREATED_TIME, new PropertyHelper(MEDIA_CREATED_TIME, MEDIA_CREATED_TIME, p.getCreatedTime(),
				G_PropertyType.DATE, Collections.singletonList(G_PropertyTag.DATE)));
		map.put(MEDIA_CAPTION_TEXT, new PropertyHelper(MEDIA_CAPTION_TEXT, MEDIA_CAPTION_TEXT, p.getCaptionText(),
				Collections.singletonList(G_PropertyTag.TEXT)));
		map.put(MEDIA_LIKE_COUNT, new PropertyHelper(MEDIA_LIKE_COUNT, MEDIA_LIKE_COUNT, p.getLikes().getCount(),
				G_PropertyType.LONG, Collections.singletonList(G_PropertyTag.STAT)));
		map.put(MEDIA_COMMENT_COUNT, new PropertyHelper(MEDIA_COMMENT_COUNT, MEDIA_COMMENT_COUNT,
				p.getComments().getCount(), G_PropertyType.LONG, Collections.singletonList(G_PropertyTag.STAT)));
		map.put(MEDIA_THUMBNAIL, new PropertyHelper(MEDIA_THUMBNAIL, MEDIA_THUMBNAIL, p.getThumbnail(),
				Collections.singletonList(G_PropertyTag.LINKED_DATA)));
		map.put(G_Parser.DTO,
				new PropertyHelper(G_Parser.DTO, G_Parser.DTO, p, G_PropertyType.OTHER, G_PropertyTag.ENTITY_TYPE));

		if ((p.getLocation().getLatitude() != null) && (p.getLocation().getLongitude() != null)) {
			map.put(MEDIA_LOCATION_LATLON,
					new PropertyHelper(MEDIA_LOCATION_LATLON, MEDIA_LOCATION_LATLON,
							p.getLocation().getLatitude() + ", " + p.getLocation().getLongitude(),
							Collections.singletonList(G_PropertyTag.GEO)));
		}

		map.put(MEDIA_LOCATION_NAME, new PropertyHelper(MEDIA_LOCATION_NAME, MEDIA_LOCATION_NAME,
				p.getLocation().getName(), Collections.singletonList(G_PropertyTag.GEO)));

		map.put(ALL_ATS, new PropertyHelper(ALL_ATS, ALL_ATS, G_PropertyType.OTHER, p.getAllAts(), G_PropertyTag.STAT));
		map.put(ALL_HASHTAGS, new PropertyHelper(ALL_HASHTAGS, ALL_HASHTAGS, G_PropertyType.OTHER, p.getAllHashTags(),
				G_PropertyTag.STAT));

		final List<G_EntityTag> tags = new ArrayList<G_EntityTag>();
		tags.add(G_EntityTag.FILE);
		final EntityHelper entity = new EntityHelper(getIdFromDoc(p), tags, null, null, map);
		return entity;
		// return list;
	}

	@Override
	public Map<String, Object> getAdditionalProperties(final Object obj) {
		if (!(obj instanceof Media)) {
			return null;
		}
		final Media p = (Media) obj;
		return p.getAdditionalProperties();
	}

	@Override
	public String getIdFromDoc(final Media p) {
		return p.getId();
	}

	@Override
	public String getReportType() {
		return "MEDIA";
	}

	// This method creates a sub graph of the nodes inside a Omni media
	// page, and a list
	// of new identifiers to search on.
	@Override
	public V_GenericGraph parse(final G_SearchResult sr, final G_EntityQuery q) {
		sr.getResult();

		final Media p = getDTO(sr, Media.class);

		// Make nodes dealing with media page.
		if (ValidationUtils.isValid(p)) {

			final String reportId = p.getId();

			// Don't scan the same object twice!
			if (phgb.isPreviouslyScannedResult(reportId)) {
				return null;
			}

			phgb.addScannedResult(reportId);
			// report node does not attach to anything.

			CreateOrUpdateNodeRequest req = new CreateOrUpdateNodeRequest();
			req.setReportId(reportId);
			req.setRelationType(G_CanonicalPropertyType.MEDIA.name());
			req.setRelationValue(G_CanonicalPropertyType.MEDIA.name());
			req.setAttachTo(null);
			req.setSubgraph(null);
			final V_GenericNode reportNode = phgb.createOrUpdateNode(req);
			reportNode.setLabel(getReportLabel(p));
			reportNode.addMedia(G_PropertyTag.IMAGE.toString(), p.getThumbnail());

			addSafeData(reportNode, reportLinkTitle, "<a href=\"" + p.getLink()
					+ "\" class=\"btn btn-primary\" target=\"" + p.getId() + "\" >" + p.getId() + "</a>");

			phgb.addGraphQueryPath(reportNode, q, null);

			if (ValidationUtils.isValid(p.getUsername())) {
				CreateOrUpdateNodeRequest r = new CreateOrUpdateNodeRequest();
				r.setOriginalId(p.getUsername());
				r.setIdType(G_CanonicalPropertyType.USERNAME.name());
				r.setNodeType(G_CanonicalPropertyType.USERNAME.name());
				r.setAttachTo(reportNode);
				r.setRelationType(G_CanonicalRelationshipType.OWNER_OF.name());
				r.setRelationValue(G_CanonicalRelationshipType.OWNER_OF.name());

				final V_GenericNode ownerNode = phgb.createOrUpdateNode(r);
				ownerNode.addMedia(G_PropertyTag.IMAGE.toString(), p.getProfilePicture());
				phgb.buildQueryForNextIteration(ownerNode);
			}

			for (int i = 0; i < p.getComments().getCommentsData().size(); i++) {
				final CommentData comment = p.getComments().getCommentsData().get(i);
				final String commentId = reportNode.getId() + "-comment-" + i;

				if (ValidationUtils.isValid(comment)) {

					V_GenericNode commentNode = null, commenterNode = null;
					CreateOrUpdateNodeRequest r = new CreateOrUpdateNodeRequest();
					r.setOriginalId(commentId);
					r.setIdType("Comment");
					r.setNodeType("Comment");
					r.setAttachTo(reportNode);
					r.setRelationType(G_CanonicalRelationshipType.PART_OF.name());
					r.setRelationValue(G_CanonicalRelationshipType.PART_OF.name());

					commentNode = phgb.createOrUpdateNode(r);

					if (ValidationUtils.isValid(commentNode)) {
						addSafeData(commentNode, "Comment Text", comment.getText());
						commentNode.setLabel(comment.getTextSample());
					}

					if (ValidationUtils.isValid(comment.getUsername())) {

						CreateOrUpdateNodeRequest commentUserReq = new CreateOrUpdateNodeRequest();
						commentUserReq.setOriginalId(comment.getUsername());
						commentUserReq.setIdType(G_CanonicalPropertyType.USERNAME.name());
						commentUserReq.setNodeType(G_CanonicalPropertyType.USERNAME.name());
						commentUserReq.setAttachTo(commentNode);
						commentUserReq.setRelationType(G_CanonicalRelationshipType.OWNER_OF.name());
						commentUserReq.setRelationValue(G_CanonicalRelationshipType.OWNER_OF.name());

						commenterNode = phgb.createOrUpdateNode(commentUserReq);

						commenterNode.addMedia(G_PropertyTag.IMAGE.toString(), comment.getProfilePicture());

						phgb.buildQueryForNextIteration(commenterNode);
					}
				}
			}

			for (int i = 0; i < p.getLikes().getLikesData().size(); i++) {
				final LikeData like = p.getLikes().getLikesData().get(i);

				if (ValidationUtils.isValid(like)) {

					V_GenericNode likerNode = null;
					if (ValidationUtils.isValid(like.getUsername())) {
						CreateOrUpdateNodeRequest likerReq = new CreateOrUpdateNodeRequest();
						likerReq.setOriginalId(like.getUsername());
						likerReq.setIdType(G_CanonicalPropertyType.USERNAME.name());
						likerReq.setNodeType(G_CanonicalPropertyType.USERNAME.name());
						likerReq.setAttachTo(reportNode);
						likerReq.setRelationType(G_CanonicalRelationshipType.LIKES.name());
						likerReq.setRelationValue(G_CanonicalRelationshipType.LIKES.name());

						likerNode = phgb.createOrUpdateNode(likerReq);
						likerNode.addMedia(G_PropertyTag.IMAGE.toString(), like.getProfilePicture());
						phgb.buildQueryForNextIteration(likerNode);
					}
				}
			}
		}

		return null;
	}
}
