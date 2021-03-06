USE [BD11248]
GO
/****** Object:  StoredProcedure [BD11248].[Curso]    Script Date: 04/11/2012 17:58:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER proc [BD11248].[Curso]
as
delete from CursoTemp 
declare @txt1 as int
declare @txt2 as varchar(200)
declare cursorCodigoCurso Cursor
for select cur_cod,cur_nome from ASP_Curso
open cursorCodigoCurso
fetch next from cursorCodigoCurso into @txt1, @txt2
while @@fetch_status=0
begin
  insert into CursoTemp(curso,codigo) values(convert(varchar(2),@txt1) + ' - ' + @txt2,@txt1)
  fetch next from cursorCodigoCurso into @txt1, @txt2
end
close cursorCodigoCurso
deallocate cursorCodigoCurso