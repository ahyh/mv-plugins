package com.yh.mv.log;

import org.apache.maven.plugin.Mojo;

public class MavenLoggerBridge implements LoggerBridge {

  private boolean verbose;
  private final Mojo mojo;

  public MavenLoggerBridge(Mojo mojo, boolean verbose) {
    this.mojo = mojo;
    this.verbose = verbose;
  }

  @Override
  public void setVerbose(boolean verbose) {
    this.verbose = verbose;
  }

  @Override
  public boolean isVerbose() {
    return verbose;
  }

  @Override
  public boolean isDebugEnabled() {
    return mojo.getLog().isDebugEnabled();
  }

  @Override
  public boolean isInfoEnabled() {
    return mojo.getLog().isInfoEnabled();
  }

  @Override
  public boolean isWarnEnabled() {
    return mojo.getLog().isWarnEnabled();
  }

  @Override
  public boolean isErrorEnabled() {
    return mojo.getLog().isErrorEnabled();
  }

  @Override
  public void debug(String msg) {
    if (verbose) {
      mojo.getLog().debug(msg);
    }
  }

  @Override
  public void debug(String format, Object arg) {
    if (verbose) {
      debug(MessageFormatter.format(format, arg));
    }
  }

  @Override
  public void debug(String format, Object arg1, Object arg2) {
    if (verbose) {
      debug(MessageFormatter.format(format, arg1, arg2));
    }
  }

  @Override
  public void debug(String format, Object... arguments) {
    if (verbose) {
      debug(MessageFormatter.arrayFormat(format, arguments));
    }
  }

  @Override
  public void debug(String msg, Throwable t) {
    if (verbose) {
      mojo.getLog().debug(msg, t);
    }
  }

  @Override
  public void info(String msg) {
    if (verbose) {
      mojo.getLog().info(msg);
    }
  }

  @Override
  public void info(String format, Object arg) {
    if (verbose) {
      info(MessageFormatter.format(format, arg));
    }
  }

  @Override
  public void info(String format, Object arg1, Object arg2) {
    if (verbose) {
      info(MessageFormatter.format(format, arg1, arg2));
    }
  }

  @Override
  public void info(String format, Object... arguments) {
    if (verbose) {
      info(MessageFormatter.arrayFormat(format, arguments));
    }
  }

  @Override
  public void info(String msg, Throwable t) {
    if (verbose) {
      mojo.getLog().info(msg, t);
    }
  }

  @Override
  public void warn(String msg) {
    if (verbose) {
      mojo.getLog().warn(msg);
    }
  }

  @Override
  public void warn(String format, Object arg) {
    if (verbose) {
      warn(MessageFormatter.format(format, arg));
    }
  }

  @Override
  public void warn(String format, Object arg1, Object arg2) {
    if (verbose) {
      warn(MessageFormatter.format(format, arg1, arg2));
    }
  }

  @Override
  public void warn(String format, Object... arguments) {
    if (verbose) {
      warn(MessageFormatter.arrayFormat(format, arguments));
    }
  }

  @Override
  public void warn(String msg, Throwable t) {
    if (verbose) {
      mojo.getLog().warn(msg, t);
    }
  }

  @Override
  public void error(String msg) {
    if (verbose) {
      mojo.getLog().error(msg);
    }
  }

  @Override
  public void error(String format, Object arg) {
    if (verbose) {
      error(MessageFormatter.format(format, arg));
    }
  }

  @Override
  public void error(String format, Object arg1, Object arg2) {
    if (verbose) {
      error(MessageFormatter.format(format, arg1, arg2));
    }
  }

  @Override
  public void error(String format, Object... arguments) {
    if (verbose) {
      error(MessageFormatter.arrayFormat(format, arguments));
    }
  }

  @Override
  public void error(String msg, Throwable t) {
    if (verbose) {
      mojo.getLog().error(msg, t);
    }
  }

  private void debug(FormattingTuple tuple) {
    if (null == tuple.getThrowable()) {
      mojo.getLog().debug(tuple.getMessage());
    } else {
      mojo.getLog().debug(tuple.getMessage(), tuple.getThrowable());
    }
  }

  private void info(FormattingTuple tuple) {
    if (null == tuple.getThrowable()) {
      mojo.getLog().info(tuple.getMessage());
    } else {
      mojo.getLog().info(tuple.getMessage(), tuple.getThrowable());
    }
  }

  private void warn(FormattingTuple tuple) {
    if (null == tuple.getThrowable()) {
      mojo.getLog().warn(tuple.getMessage());
    } else {
      mojo.getLog().warn(tuple.getMessage(), tuple.getThrowable());
    }
  }

  private void error(FormattingTuple tuple) {
    if (null == tuple.getThrowable()) {
      mojo.getLog().error(tuple.getMessage());
    } else {
      mojo.getLog().error(tuple.getMessage(), tuple.getThrowable());
    }
  }
}