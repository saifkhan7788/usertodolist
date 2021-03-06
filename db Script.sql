USE [userTodoList]
GO
/****** Object:  Table [dbo].[todo]    Script Date: 9/13/2021 4:15:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[todo](
	[id] [bigint] NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](150) NULL,
 CONSTRAINT [PK_Todo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_todos]    Script Date: 9/13/2021 4:15:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_todos](
	[id] [bigint] NOT NULL,
	[status] [bit] NULL,
	[description] [nvarchar](150) NULL,
	[name] [nvarchar](50) NULL,
	[user_id] [bigint] NOT NULL,
	[todo_id] [bigint] NOT NULL,
	[action] [bit] NULL,
 CONSTRAINT [PK_user_todos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 9/13/2021 4:15:12 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [bigint] NOT NULL,
	[name] [nvarchar](50) NULL,
	[email] [nvarchar](150) NULL,
	[phone] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[user_todos]  WITH CHECK ADD  CONSTRAINT [FK_user_todos_Todo] FOREIGN KEY([todo_id])
REFERENCES [dbo].[todo] ([id])
GO
ALTER TABLE [dbo].[user_todos] CHECK CONSTRAINT [FK_user_todos_Todo]
GO
ALTER TABLE [dbo].[user_todos]  WITH CHECK ADD  CONSTRAINT [FK_user_todos_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_todos] CHECK CONSTRAINT [FK_user_todos_users]
GO
