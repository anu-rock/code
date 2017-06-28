class ArticlesController < ApplicationController
  # GET all articles
  def index
    @articles = Article.all # instance variables are passed to the view
  end

  def new
  end

  # POST request from "new" form will come here
  def create
    @article = Article.new(article_params)
    @article.save
    redirect_to @article
  end

  # GET an article by id
  def show
    @article = Article.find(params[:id]) # instance variables are passed to the view
  end

  # A method that returns CSRF-safe "article"
  private
  def article_params
    params.require(:article).permit(:title, :text) # strong paramters
  end
end
