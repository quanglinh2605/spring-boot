<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<div class="col-md-6"
	style="margin-left: auto; margin-right: auto; padding-top: 50px;">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">Add Movie</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<s:form role="form" method="post" modelAttribute="movie"
			enctype="multipart/form-data"
			action="${ pageContext.request.contextPath }/admin/movie/add">
			<div class="card-body">
				<div class="form-group">
					<label for="movieName">Movie Name</label>
					<s:input path="movieName" class="form-control" id="movieName"
						placeholder="Name" required="required"/>
					<span style="color: red;"><s:errors path="movieName"></s:errors></span>
				</div>
				<div class="form-group">
					<label for="movieDescription">Movie desription</label>
					<s:textarea cols="20" rows="5" path="movieDescription"
						class="form-control" id="movieDescription"
						placeholder="Desription" />
				</div>
				<div class="form-group">
					<label for="movieTrailer">Movie Trailer</label>
					<s:input path="movieTrailer" class="form-control" id="movieTrailer"
						placeholder="Trailer" />
				</div>
				<div class="form-group">
					<label for="movieCens">Movie Cens</label>
					<s:select path="movieCens" class="form-control select2">
						<s:option value="13+">13+</s:option>
						<s:option value="16+">16+</s:option>
						<s:option value="18+">18+</s:option>
						<s:option value="P">P</s:option>
					</s:select>
				</div>
				<div>
					<label for="movieLength">Movie Length</label>
					<s:input path="movieLength" class="form-control" id="movieLength" title="02:12:15, 01:45:17, ..."/>
				</div>
				<div class="form-group">
					<label for="movieFormat">Movie Format</label>
					<s:input path="movieFormat" class="form-control" id="movieFormat" />
				</div>				
				<div>
					<label for="Choose Poster">Choose Poster</label>
					<div class="avatar">
						<img id="imgpreview"
							src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRSwa8DjX6_FNlQ7VwxCHc0vOOmOXyUgcsemL5pm9WPRjFS1vSr&usqp=CAU"
							class="img-fluid" style="max-width: 300 px; max-height: 300px;" />
					</div>
					<div class="file-field">
						<p>
							<strong id="xImagePath">Selected Image URL</strong><br /> <input
								class="btn btn-primary btn-sm waves-effect waves-light"
								type="button" value="Browse Image"
								onclick="BrowseServer( 'Images:/', 'xImagePath' );" />
						</p>
						<s:hidden path="moviePoster" id="poster" />
					</div>
				</div>
			</div>
			<!-- /.card-body -->

			<div class="card-footer">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</s:form>
	</div>
</div>
<script
	src="${ pageContext.request.contextPath }/resources/ckfinder/ckfinder.js"></script>
<script>
	function BrowseServer(startupPath, functionData) {
		// You can use the "CKFinder" class to render CKFinder in a page:
		var finder = new CKFinder();

		// The path for the installation of CKFinder (default = "/ckfinder/").
		finder.basePath = '../';

		//Startup path in a form: "Type:/path/to/directory/"
		finder.startupPath = startupPath;

		// Name of a function which is called when a file is selected in CKFinder.
		finder.selectActionFunction = SetFileField;

		// Additional data to be passed to the selectActionFunction in a second argument.
		// We'll use this feature to pass the Id of a field that will be updated.
		finder.selectActionData = functionData;

		// Name of a function which is called when a thumbnail is selected in CKFinder. Preview img
		// finder.selectThumbnailActionFunction = ShowThumbnails;

		// Launch CKFinder
		finder.popup();
	}

	// This is a sample function which is called when a file is selected in CKFinder.
	function SetFileField(fileUrl, data) {
		document.getElementById(data["selectActionData"]).innerHTML = this
				.getSelectedFile().name;
		document.getElementById("imgpreview").src = fileUrl;
		$('#poster').val(fileUrl);
	}
	/*Avatar end*/
</script>

