package datn.web.service;

import java.util.List;

import datn.web.entity.Comment;
import datn.web.model.CommentModel;

public interface CommentService {

	List<Comment> getListCommentByProductId(Integer id);

	CommentModel createComment(CommentModel commentModel);

	List<Comment> getListCommentPending();

	Comment getCommentByCommentId(Integer id);

	void approveComment(Integer id);

	void delete(Integer id);

	List<Comment> getListCommentChecked();

	int getCountCommentByProductNameSearch(String nameSearch);

	int getAllStarCommentByProductNameSearch(String nameSearch);

}
