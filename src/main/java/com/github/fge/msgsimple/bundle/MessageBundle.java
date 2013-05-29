package com.github.fge.msgsimple.bundle;

import com.github.fge.msgsimple.source.MessageSource;

import java.util.ArrayList;
import java.util.List;

public final class MessageBundle
{
    private final List<MessageSource> sources;

    private MessageBundle(final Builder builder)
    {
        sources = new ArrayList<MessageSource>(builder.sources);
    }

    public String getKey(final String key)
    {
        String ret;

        for (final MessageSource source: sources) {
            ret = source.getMessage(key);
            if (ret != null)
                return ret;
        }

        return key;
    }

    public static final class Builder
    {
        private final List<MessageSource> sources
            = new ArrayList<MessageSource>();

        public Builder()
        {
        }

        public Builder(final MessageBundle bundle)
        {
            sources.addAll(bundle.sources);
        }

        public Builder addSource(final MessageSource source)
        {
            sources.add(source);
            return this;
        }
    }
}