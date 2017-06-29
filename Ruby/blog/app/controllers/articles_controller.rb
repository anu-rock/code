class ArticlesController < ApplicationController
  # GET all articles
  def index
    @articles = Article.all.order 'created_at desc' # instance variables are passed to the view
  end

  def new
      # to avoid null reference exception for
      # @article.errors.any? on new.html.erb
      @article = Article.new
  end

  # POST request from "new" form will come here
  def create
    @article = Article.new(article_params)
    if @article.save
        redirect_to articles_path
    else
        render 'new'
    end
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
