<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="notice-search">
	<form action="/Mylog/search/notice/list" method="post">
		<div>
			<span> <svg id="notice-svg" width="19" height="19"
					viewBox="0 0 17 17">
                                        <path fill-rule="evenodd"
						d="M13.66 7.36a6.3 6.3 0 1 1-12.598 0 6.3 6.3 0 0 1 12.598 0zm-1.73 5.772a7.36 7.36 0 1 1 1.201-1.201l3.636 3.635c.31.31.31.815 0 1.126l-.075.075a.796.796 0 0 1-1.126 0l-3.636-3.635z"
						clip-rule="evenodd" fill="currentColor"></path>
                                    </svg>
			</span>
		</div>
		<input type="text" name="notice-search" placeholder="검색어를 입력하세요">
		<select name="category-no">
				<option value="1">카테고리 1</option>
				<option value="2">카테고리 2</option>
				<option value="3">카테고리 3</option>
			</select>
	</form>
</div>