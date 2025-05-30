<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規プレイヤー追加</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">新規プレイヤー登録</h2>
    <form action="Playerservlet" method="post">
        <div class="mb-3">
            <label for="country_id" class="form-label">国</label>
            <input type="text" class="form-control" id="country_id" name="country_id" required>
        </div>
        <div class="mb-3">
            <label for="uniform_num" class="form-label">ユニフォーム番号</label>
            <input type="number" class="form-control" id="uniform_num" name="uniform_num" required>
        </div>
        <div class="mb-3">
            <label for="position" class="form-label">ポジション</label>
            <input type="text" class="form-control" id="position" name="position" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">名前</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="club" class="form-label">クラブ</label>
            <input type="text" class="form-control" id="club" name="club">
        </div>
        <div class="mb-3">
            <label for="birth" class="form-label">生年月日</label>
            <input type="date" class="form-control" id="birth" name="birth" required>
        </div>
        <div class="mb-3">
            <label for="height" class="form-label">身長(cm)</label>
            <input type="number" class="form-control" id="height" name="height" required>
        </div>
        <div class="mb-3">
            <label for="weight" class="form-label">体重(kg)</label>
            <input type="number" class="form-control" id="weight" name="weight" required>
        </div>
        <button type="submit" class="btn btn-primary">追加</button>
    </form>
</div>
</body>
</html>