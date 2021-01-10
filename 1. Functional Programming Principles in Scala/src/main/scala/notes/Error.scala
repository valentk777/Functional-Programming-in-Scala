package notes

object Error {
    def error(message:String) = throw new Error(message)

  // Any Val will be used there, because it's a base type for both boolean and int
  def type_convert(param:Boolean): AnyVal = if(param) 1 else true
}
